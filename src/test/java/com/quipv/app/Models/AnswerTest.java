package com.quipv.app.Models;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for Answer module.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AnswerTest {
    private Answer answer;
    private ArrayList<String> outcomes;

    @Before
    public void setup() {
        outcomes = new ArrayList<>();
        outcomes.add("O1");
        outcomes.add("O2");
        outcomes.add("O3");

        answer = new Answer.AnswerBuilder().with($ -> {
            $.fullAnswer = "FA1";
            $.brokenAnswer = "BA1";
            $.projectName = "Test Project 1";
            $.outcomes = outcomes;
            $.driver = "D1";
            $.respondentID = "21";
            $.questionID = "11";
        }).build();
    }

    @Test
    public void testCreateAnswer()  {
        assertEquals( "FA1", answer.getFullAnswer());
        assertEquals( "BA1", answer.getBrokenAnswer());
        assertEquals( outcomes, answer.getOutcomes());
        assertEquals( "D1", answer.getDriver());
        assertEquals( "21", answer.getRespondentID());
        assertEquals( "11", answer.getQuestionID());
        assertEquals("Test Project 1",answer.getProjectName());
    }
}
