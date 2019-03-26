package com.quipv.app.Helpers;

import com.quipv.app.Models.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectHelperTest {
    private List<MaintableEntity> interviewEntries = new ArrayList<>();
    private List<SankeyEntity> sankeyEntries = new ArrayList<>();

    @Before
    public void setup() {
        MaintableEntity entry1 = new MaintableEntity();
        entry1.setRowId(1);
        entry1.setDriverOfChange("D1");
        entry1.setOutcome1("O1");
        entry1.setOutcome2("O2");
        entry1.setOutcome3("O3");
        entry1.setProjectName("Test Project Name 1");
        entry1.setQuestionId("Test QuestionID 1");
        entry1.setQuestion("Test question 1");
        entry1.setFullAnswer("Test full answer 1");
        entry1.setBrokenAnswer("Test broken answer 1");
        entry1.setRespondentId("Test resp ID 1");
        entry1.setInterviewType("Test interview type 1");

        MaintableEntity entry2 = new MaintableEntity();
        entry2.setRowId(2);
        entry2.setDriverOfChange("D2");
        entry2.setOutcome1("O3");
        entry2.setOutcome2("O4");
        entry2.setProjectName("Test Project Name 1");
        entry2.setQuestionId("Test QuestionID 2");
        entry2.setQuestion("Test question 2");
        entry2.setFullAnswer("Test full answer 2");
        entry2.setBrokenAnswer("Test broken answer 2");
        entry2.setRespondentId("Test resp ID 2");
        entry2.setInterviewType("Test interview type 2");

        MaintableEntity entry3 = new MaintableEntity();
        entry3.setRowId(3);
        entry3.setDriverOfChange("D1");
        entry3.setOutcome1("O2");
        entry3.setOutcome2("O4");
        entry3.setOutcome3("O5");
        entry3.setProjectName("Test Project Name 1");
        entry3.setQuestionId("Test QuestionID 2");
        entry3.setQuestion("Test question 2");
        entry3.setFullAnswer("Test full answer 3");
        entry3.setBrokenAnswer("Test broken answer 3");
        entry3.setRespondentId("Test resp ID 3");
        entry3.setInterviewType("Test interview type 2");

        SankeyEntity sankey1 = new SankeyEntity();
        sankey1.setId(1);
        sankey1.setProjectname("Test Project Name 1");
        sankey1.setRowId(1);
        sankey1.setInterviewType("Test Interview Type 1");
        sankey1.setSource("D1");
        sankey1.setTarget("O1");
        sankey1.setSourceDescription("Test Driver 1");
        sankey1.setTargetDescription("Test Outcome 1");
        sankey1.setFileinstanceId(1);
        sankey1.setSourceNegPos("Test Source NegPos 1");
        sankey1.setTargetNegPos("Test Target NegPos 1");
        sankey1.setInterviewType("Test interview type 1");

        SankeyEntity sankey2 = new SankeyEntity();
        sankey2.setId(2);
        sankey2.setProjectname("Test Project Name 1");
        sankey2.setRowId(1);
        sankey2.setInterviewType("Test Interview Type 1");
        sankey2.setSource("O1");
        sankey2.setTarget("O2");
        sankey2.setSourceDescription("Test Outcome 1");
        sankey2.setTargetDescription("Test Outcome 2");
        sankey2.setFileinstanceId(1);
        sankey2.setSourceNegPos("Test Source NegPos 2");
        sankey2.setTargetNegPos("Test Target NegPos 2");
        sankey2.setInterviewType("Test interview type 1");

        SankeyEntity sankey3 = new SankeyEntity();
        sankey3.setId(3);
        sankey3.setProjectname("Test Project Name 1");
        sankey3.setRowId(1);
        sankey3.setInterviewType("Test Interview Type 1");
        sankey3.setSource("O2");
        sankey3.setTarget("O3");
        sankey3.setSourceDescription("Test Outcome 2");
        sankey3.setTargetDescription("Test Outcome 3");
        sankey3.setFileinstanceId(1);
        sankey3.setSourceNegPos("Test Source NegPos 3");
        sankey3.setTargetNegPos("Test Target NegPos 3");
        sankey3.setInterviewType("Test interview type 1");

        SankeyEntity sankey4 = new SankeyEntity();
        sankey4.setId(4);
        sankey4.setProjectname("Test Project Name 1");
        sankey4.setRowId(2);
        sankey4.setInterviewType("Test Interview Type 2");
        sankey4.setSource("D2");
        sankey4.setTarget("O3");
        sankey4.setSourceDescription("Test Driver 2");
        sankey4.setTargetDescription("Test Outcome 3");
        sankey4.setFileinstanceId(1);
        sankey4.setSourceNegPos("Test Source NegPos 4");
        sankey4.setTargetNegPos("Test Target NegPos 4");
        sankey4.setInterviewType("Test interview type 2");

        SankeyEntity sankey5 = new SankeyEntity();
        sankey5.setId(5);
        sankey5.setProjectname("Test Project Name 1");
        sankey5.setRowId(2);
        sankey5.setInterviewType("Test Interview Type 2");
        sankey5.setSource("O3");
        sankey5.setTarget("O4");
        sankey5.setSourceDescription("Test Outcome 3");
        sankey5.setTargetDescription("Test Outcome 4");
        sankey5.setFileinstanceId(1);
        sankey5.setSourceNegPos("Test Source NegPos 5");
        sankey5.setTargetNegPos("Test Target NegPos 5");
        sankey5.setInterviewType("Test interview type 2");

        SankeyEntity sankey6 = new SankeyEntity();
        sankey6.setId(6);
        sankey6.setProjectname("Test Project Name 1");
        sankey6.setRowId(3);
        sankey6.setInterviewType("Test Interview Type 2");
        sankey6.setSource("D1");
        sankey6.setTarget("O2");
        sankey6.setSourceDescription("Test Driver 1");
        sankey6.setTargetDescription("Test Outcome 2");
        sankey6.setFileinstanceId(1);
        sankey6.setSourceNegPos("Test Source NegPos 6");
        sankey6.setTargetNegPos("Test Target NegPos 6");
        sankey6.setInterviewType("Test interview type 2");

        SankeyEntity sankey7 = new SankeyEntity();
        sankey7.setId(7);
        sankey7.setProjectname("Test Project Name 1");
        sankey7.setRowId(3);
        sankey7.setInterviewType("Test Interview Type 2");
        sankey7.setSource("O2");
        sankey7.setTarget("O4");
        sankey7.setSourceDescription("Test Outcome 2");
        sankey7.setTargetDescription("Test Outcome 4");
        sankey7.setFileinstanceId(1);
        sankey7.setSourceNegPos("Test Source NegPos 7");
        sankey7.setTargetNegPos("Test Target NegPos 7");
        sankey7.setInterviewType("Test interview type 2");

        SankeyEntity sankey8 = new SankeyEntity();
        sankey8.setId(8);
        sankey8.setProjectname("Test Project Name 1");
        sankey8.setRowId(3);
        sankey8.setInterviewType("Test Interview Type 2");
        sankey8.setSource("O4");
        sankey8.setTarget("O5");
        sankey8.setSourceDescription("Test Outcome 4");
        sankey8.setTargetDescription("Test Outcome 5");
        sankey8.setFileinstanceId(1);
        sankey8.setSourceNegPos("Test Source NegPos 8");
        sankey8.setTargetNegPos("Test Target NegPos 8");
        sankey8.setInterviewType("Test interview type 2");

        //Add entries to List
        interviewEntries.add(entry1);
        interviewEntries.add(entry2);
        interviewEntries.add(entry3);
        sankeyEntries.add(sankey1);
        sankeyEntries.add(sankey2);
        sankeyEntries.add(sankey3);
        sankeyEntries.add(sankey4);
        sankeyEntries.add(sankey5);
        sankeyEntries.add(sankey6);
        sankeyEntries.add(sankey7);
        sankeyEntries.add(sankey8);
    }

    @Test
    public void testProjectCreation(){
        Project project = ProjectHelper.populate(interviewEntries,sankeyEntries);
        //Name: Test Project Name 1
        //Questions: Test QuestionID 1, Test QuestionID 2
        //Answers:Test full answer 1, Test full answer 2, Test full answer 3
        //Respondents: Test resp ID 1, Test resp ID 2, Test resp ID 3

        ArrayList<Question> questions = project.getQuestions();
        List<Answer> answers = project.getAnswers();
        ArrayList<Respondent> respondents = project.getRespondents();

        Assert.assertNull(ProjectHelper.populate(new ArrayList<>(), sankeyEntries));
        Assert.assertEquals("Test Project Name 1", project.getName());
        Assert.assertEquals(2, questions.size());
        Assert.assertEquals("Test QuestionID 1", questions.get(0).getQuestionID());
        Assert.assertEquals("Test QuestionID 2", questions.get(1).getQuestionID());
        Assert.assertEquals(3, answers.size());
        Assert.assertEquals("Test full answer 1", answers.get(0).getFullAnswer());
        Assert.assertEquals("Test full answer 2", answers.get(1).getFullAnswer());
        Assert.assertEquals("Test full answer 3", answers.get(2).getFullAnswer());
        Assert.assertEquals(3, respondents.size());
        Assert.assertEquals("Test resp ID 1", respondents.get(0).getRespondentID());
        Assert.assertEquals("Test resp ID 2", respondents.get(1).getRespondentID());
        Assert.assertEquals("Test resp ID 3", respondents.get(2).getRespondentID());
    }
}
