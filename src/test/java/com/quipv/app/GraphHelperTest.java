package com.quipv.app;

import com.quipv.app.Models.*;
import com.quipv.app.Repositories.SankeyRepository;
import com.quipv.app.Helpers.GraphHelper;
import com.quipv.app.Repositories.MaintableRepository;
import com.quipv.app.Helpers.ProjectHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GraphHelperTest{

    @MockBean
    private MaintableRepository maintableRepository;

    @MockBean
    private SankeyRepository sankeyRepository;

    @Before
    public void setup() {
        List<MaintableEntity> interviewEntries = new ArrayList<>();
        MaintableEntity entry1 = new MaintableEntity();
        entry1.setRowId(1);
        entry1.setDriverOfChange("D1");
        entry1.setOutcome1("O1");
        entry1.setOutcome2("O2");
        entry1.setOutcome3("O3");
        entry1.setProjectName("Test project name");
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
        entry2.setOutcome3("O1");
        entry2.setProjectName("Test project name");
        entry2.setQuestionId("Test QuestionID 2");
        entry2.setQuestion("Test question 2");
        entry2.setFullAnswer("Test full answer 2");
        entry2.setBrokenAnswer("Test broken answer 2");
        entry2.setRespondentId("Test resp ID 2");
        entry2.setInterviewType("Test interview type 2");

        List<SankeyEntity> sankeyEntries = new ArrayList<>();
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
        sankey6.setRowId(2);
        sankey6.setInterviewType("Test Interview Type 2");
        sankey6.setSource("O4");
        sankey6.setTarget("O1");
        sankey6.setSourceDescription("Test Outcome 4");
        sankey6.setTargetDescription("Test Outcome 1");
        sankey6.setFileinstanceId(1);
        sankey6.setSourceNegPos("Test Source NegPos 6");
        sankey6.setTargetNegPos("Test Target NegPos 6");
        sankey6.setInterviewType("Test interview type 2");

        //Add entries to List
        interviewEntries.add(entry1);
        interviewEntries.add(entry2);
        sankeyEntries.add(sankey1);
        sankeyEntries.add(sankey2);
        sankeyEntries.add(sankey3);
        sankeyEntries.add(sankey4);
        sankeyEntries.add(sankey5);
        sankeyEntries.add(sankey6);

        given(maintableRepository.findAll()).willAnswer(invocationOnMock -> interviewEntries);
        given(sankeyRepository.findAll()).willAnswer(invocationOnMock -> sankeyEntries);
    }

    @Test
    public void testGraphIsConstructedCorrectly(){
        Project project = ProjectHelper.populate(maintableRepository,sankeyRepository);
        Graph graph = GraphHelper.constructGraph(project);
        //Vertices should be D1, D2, O1, O2, O3, O4
        Assert.assertEquals(6,graph.getVertices().size());
        GraphNode D1 = graph.getNodeByName("Test Driver 1").get();
        GraphNode O1 = graph.getNodeByName("Test Outcome 1").get();
        GraphNode O2 = graph.getNodeByName("Test Outcome 2").get();
        GraphNode O3 = graph.getNodeByName("Test Outcome 3").get();
        GraphNode O4 = graph.getNodeByName("Test Outcome 4").get();
        Assert.assertTrue(D1.getNeighbourNodes().contains(O1));
        Assert.assertTrue(O1.getNeighbourNodes().contains(O2));
        Assert.assertTrue(O2.getNeighbourNodes().contains(O3));
        Assert.assertTrue(O4.getNeighbourNodes().contains(O1));
    }
}