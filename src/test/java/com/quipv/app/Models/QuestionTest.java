package com.quipv.app.Models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Unit test for Question module.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionTest {

    @Test
    public void testCreateQuestion() {

        Question question1 = new Question.QuestionBuilder().with($ -> {
            $.questionID = "1";
            $.text = "Question 1";
        }).build();

        Question question11 = new Question.QuestionBuilder().with($ -> {
            $.questionID = "11";
            $.text = "Question 11";
        }).build();

        //Test Creation
        assertEquals( "1", question1.getQuestionID());
        assertEquals( "Question 1", question1.getText());
        question11.setShowInVis(false);
        assertFalse(question11.isShowInVis());
    }

    @Test
    public void testEquals() {

        Question questionA = new Question.QuestionBuilder().with($ -> {
            $.questionID = "1";
            $.text = "Question a";
        }).build();

        Question questionB = new Question.QuestionBuilder().with($ -> {
            $.questionID = "1";
            $.text = "Question b";
        }).build();

        Question questionC = new Question.QuestionBuilder().with($ -> {
            $.questionID = "2";
            $.text = "Question C";
        }).build();

        //Test Equal
        assertTrue(questionA.equals(questionA));
        assertTrue(questionA.equals(questionB));
        assertTrue(questionB.equals(questionA));
        assertFalse(questionA.equals(questionC));
        assertFalse(questionA.equals("NaQuestion"));
    }
}
