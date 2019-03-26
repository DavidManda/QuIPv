package com.quipv.app.Models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Unit test for Respondent module.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RespondentTest {

    @Test
    public void testCreateRespondent() {

       Respondent respondent1 = new Respondent.RespondentBuilder().with($ -> {
            $.respondentID = "1";
            $.interviewType = "Individual";
        }).build();

        Respondent respondent11 = new Respondent.RespondentBuilder().with($ -> {
            $.respondentID = "11";
            $.interviewType = "Individual";
        }).build();

        assertEquals( "1", respondent1.getRespondentID());
        assertEquals( "Individual", respondent1.getInterviewType());

        respondent11.setShowInVis(false);
        assertFalse(respondent11.isShowInVis());
    }
}
