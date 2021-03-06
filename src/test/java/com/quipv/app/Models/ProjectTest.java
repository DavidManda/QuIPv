package com.quipv.app.Models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

/**
 * Unit test for Project module.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectTest {

    @Test
    public void testCreateProject() {
        ArrayList<String> outcomes = new ArrayList<>();
        outcomes.add("O1");
        outcomes.add("O2");
        outcomes.add("O3");

        Answer answer = new Answer.AnswerBuilder().with($ -> {
            $.fullAnswer = "FA1";
            $.brokenAnswer = "BA1";
            $.outcomes = outcomes;
            $.driver = "D1";
            $.respondentID = "21";
            $.questionID = "11";
        }).build();

        Respondent respondent1 = new Respondent.RespondentBuilder().with($ -> {
            $.respondentID = "1";
            $.interviewType = "Individual";
        }).build();

        Question question1 = new Question.QuestionBuilder().with($ -> {
            $.questionID = "1";
            $.text = "Question 1";
        }).build();

        Project project = new Project.ProjectBuilder().with($ -> {
            $.name = "TP1";
            $.questions = new ArrayList<Question>(){{add(question1);}};
            $.answers = new ArrayList<Answer>(){{add(answer);}};
            $.respondents = new ArrayList<Respondent>(){{add(respondent1);}};
        }).build();

        //Test Project Created Correctly
        assertEquals( "TP1", project.getName());
        assertEquals( new ArrayList<Question>(){{add(question1);}}, project.getQuestions());
        assertEquals( new ArrayList<Answer>(){{add(answer);}}, project.getAnswers());
        assertEquals( new ArrayList<Respondent>(){{add(respondent1);}}, project.getRespondents());

        //Test toString
        String expected = "Questions: 1, \nAnswers: 11, \nRespondents: 1, \n\n";
        assertEquals(expected, project.toString());
    }

}
