package com.quipv.app.Models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for InterviewEntry module.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class InterviewEntryTest {

    @Test
    public void testCreateInterviewEntry() {
        InterviewEntry interviewEntry = new InterviewEntry.InterviewEntryBuilder().with($ -> {
            $.questionID = "1";
            $.question = "Question1";
            $.respondentID = "2";
            $.interviewType = "Int1";
            $.fullAnswer = "FA1";
            $.brokenAnswer = "BA1";
            $.driver = "DR1";
            $.primaryOutcome = "Out1";
            $.secondaryOutcome = "Out2";
            $.tertiaryOutcome = "Out3";
            $.projectName = "Project1";
        }).build();

        //Test Creation
        assertEquals( "1", interviewEntry.getQuestionID());
        assertEquals( "Question1", interviewEntry.getQuestion());
        assertEquals( "2", interviewEntry.getRespondentID());
        assertEquals( "Int1", interviewEntry.getInterviewType());
        assertEquals( "FA1", interviewEntry.getFullAnswer());
        assertEquals( "BA1", interviewEntry.getBrokenAnswer());
        assertEquals( "DR1", interviewEntry.getDriver());
        assertEquals( "Out1", interviewEntry.getPrimaryOutcome());
        assertEquals( "Out2", interviewEntry.getSecondaryOutcome());
        assertEquals( "Out3", interviewEntry.getTertiaryOutcome());
        assertEquals( "Project1", interviewEntry.getProjectName());

        //Test toString
        String expected = "Interview entry with:\n questionID = 1\n question = Question1\n respondentID = 2" +
                "\n full answer = FA1\n broken answer = BA1\n driver = DR1\n primary outcome = " +
                "Out1\n secondary outcome = Out2\n tertiary outcome = Out3\n project name = Project1\n";
        assertEquals(expected,interviewEntry.toString());
    }
}
