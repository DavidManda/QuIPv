package com.quipv.app.Helpers;



import com.quipv.app.DBO.MaintableEntity;
import com.quipv.app.DBO.MaintableRepository;
import com.quipv.app.DBO.SankeyEntity;
import com.quipv.app.DBO.SankeyRepository;
import com.quipv.app.Models.*;

import java.util.*;
import java.util.stream.Collectors;

public class ProjectHelper {
    public static Project populate(MaintableRepository maintableRepository, SankeyRepository sankeyRepository){

        List<MaintableEntity> maintableEntries = new LinkedList<>();
        List<SankeyEntity> sankeyEntries = new LinkedList<>();

        Iterable<MaintableEntity> entries = maintableRepository.findAll();
        Iterable<SankeyEntity> sankeyEntities = sankeyRepository.findAll();

        entries.forEach(maintableEntries::add);
        sankeyEntities.forEach(sankeyEntries::add);

        Project project = populateProject(maintableEntries,maintableEntries.get(0).getProjectName(), sankeyEntries);

        return project;
    }

    private static Project populateProject(List<MaintableEntity> interiewEntries, String projectName, List<SankeyEntity> sankeyEntities) {
        Project project;
        ArrayList<Question> questions = new ArrayList<Question>();
        final List<Answer> answers = new ArrayList<Answer>();
        ArrayList<Respondent> respondents= new ArrayList<Respondent>();

        for (MaintableEntity interviewEntry : interiewEntries) {
            Question q = new Question.QuestionBuilder().with($ -> {
                try {
                    $.questionID = interviewEntry.getQuestionId();
                    $.text = interviewEntry.getQuestion();
                } catch (Exception e){ System.out.println("Exception in lambda" + e);}
            }).build();
            questions.add(q);

            ArrayList<String> outcomes = new ArrayList<>();
            outcomes.add(interviewEntry.getOutcome1());
            outcomes.add(interviewEntry.getOutcome2());
            outcomes.add(interviewEntry.getOutcome3());

            Answer a = new Answer.AnswerBuilder().with($ -> {
                try {
                    $.projectName = interviewEntry.getProjectName();
                    $.fullAnswer =interviewEntry.getFullAnswer();
                    $.brokenAnswer = interviewEntry.getBrokenAnswer();
                    $.outcomes = outcomes;
                    $.rowId = interviewEntry.getRowId();
                    $.driver = interviewEntry.getDriverOfChange();
                    $.respondentID = interviewEntry.getRespondentId();
                    $.questionID = interviewEntry.getQuestionId();
                } catch (Exception e){ System.out.println("Exception in lambda" + e);}
            }).build();
            answers.add(a);

            Respondent r = new Respondent.RespondentBuilder().with($ -> {
                try {
                    $.respondentID = interviewEntry.getRespondentId();
                    $.interviewType = interviewEntry.getInterviewType();
                } catch (Exception e){ System.out.println("Exception in lambda" + e);}
            }).build();
            respondents.add(r);
        }

        Set<Question> questionsWithoutDuplicates = new LinkedHashSet<Question>(questions);
        Set<Answer> answersWithoutDuplicates = new LinkedHashSet<Answer>(answers);
        questions.clear();
        answers.clear();

        questions.addAll(questionsWithoutDuplicates);
        answers.addAll(answersWithoutDuplicates);
        final List<Answer> answersWithActualNames = getActualNamesForDriversAndOutcomes(answers,sankeyEntities,projectName);

//        System.out.println(answers);
//        System.out.println(getActualNamesForDriversAndOutcomes(answers,sankeyEntities,projectName));
        project = new Project.ProjectBuilder().with($ -> {
            try {
                $.name = projectName;
                $.questions = questions;
                $.answers = answersWithActualNames;
                $.respondents= respondents;
            } catch (Exception e){ System.out.println("Exception in lambda" + e);}

        }).build();

        return project;
    }

    private static List<Answer> getActualNamesForDriversAndOutcomes(List<Answer> answers, List<SankeyEntity> sankeyEntities, String projectName){
        for(int i=0; i<answers.size();i++){
            Answer answer = answers.get(i);
            Integer rowId = answer.getRowId();
            String driverName = answer.getDriver();
            if(driverName == null)
                continue;
            List<String> outcomes = answer.getOutcomes();
            String actualDriverName = null;
            ArrayList<String> actualOutcomesNames = new ArrayList<>();
            List<SankeyEntity> sankeyEntries = sankeyEntities.stream()
                                            .filter(a -> a.getRowId() == rowId && a.getProjectname().equals(projectName))
                                            .collect(Collectors.toList());
            SankeyEntity driverEntry = sankeyEntities.stream()
                                                    .filter(a -> a.getSource().equals(driverName))
                                                    .findAny()
                                                    .orElse(null);
            if(driverEntry != null){
                actualDriverName = driverEntry.getSourceDescription();
            }
            for(String outcome : outcomes){
                if(outcome != null){
                    SankeyEntity sankeyEntity = sankeyEntities.stream()
                            .filter(a -> a.getSource().equals(outcome))
                            .findAny()
                            .orElse(null);
                    actualOutcomesNames.add(sankeyEntity.getSourceDescription());
                }
                else{
                    actualOutcomesNames.add(null);
                }
            }

            answer.setDriver(actualDriverName);
            answer.setOutcomes(actualOutcomesNames);
            answers.set(i,answer);
        }
        System.out.println(answers);
        return answers;
    }

}
