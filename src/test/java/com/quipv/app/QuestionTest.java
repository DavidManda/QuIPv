package com.quipv.app;

import com.quipv.app.Models.Question;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;



/**
 * Unit test for Question module.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionTest
{
    /**
     * Rigourous Test :-)
     */
    @Test
    public void testCreateQuestion()
    {

        Question question1 = new Question.QuestionBuilder().with($ -> {
            $.questionID = "1";
            $.text = "Question 1";
        }).build();

        Question question11 = new Question.QuestionBuilder().with($ -> {
            $.questionID = "11";
            $.text = "Question 11";
        }).build();

        assertEquals( "1", question1.getQuestionID());
        assertEquals( "Question 1", question1.getText());
//        assertEquals( 10, question11.compareTo(question1));

        question11.setShowInVis(false);
        assertFalse(question11.isShowInVis());
    }
}
