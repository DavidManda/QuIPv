package com.quipv.app.Helpers;



import com.quipv.app.DBO.SdrLiveMaintableEntity;
import com.quipv.app.Models.*;

import java.util.*;

public class ProjectHelper {
    public static Project populate(MaintableRepository maintableRepository){

        List<SdrLiveMaintableEntity> interviewEntries = new LinkedList<>();
        Iterable<SdrLiveMaintableEntity> entries = populateInterviewEntries(maintableRepository);
        entries.forEach(interviewEntries::add);

        Project project = populateProject(interviewEntries,interviewEntries.get(0).getProjectName());

        return project;
    }

    private static Iterable<SdrLiveMaintableEntity> populateInterviewEntries(MaintableRepository maintableRepository) {
        Iterable<SdrLiveMaintableEntity> interiewEntries = maintableRepository.findAll();
        return interiewEntries;
    }

    private static Project populateProject(List<SdrLiveMaintableEntity> interiewEntries, String projectName) {
        Project project;
        ArrayList<Question> questions = new ArrayList<Question>();
        ArrayList<Answer> answers = new ArrayList<Answer>();
        ArrayList<Respondent> respondents= new ArrayList<Respondent>();

        for (SdrLiveMaintableEntity interviewEntry : interiewEntries) {
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
                    $.fullAnswer =interviewEntry.getFullAnswer();
                    $.brokenAnswer = interviewEntry.getBrokenAnswer();
                    $.outcomes = outcomes;
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

        project = new Project.ProjectBuilder().with($ -> {
            try {
                $.name = projectName;
                $.questions = questions;
                $.answers = answers;
                $.respondents= respondents;
            } catch (Exception e){ System.out.println("Exception in lambda" + e);}

        }).build();

        return project;
    }

}
