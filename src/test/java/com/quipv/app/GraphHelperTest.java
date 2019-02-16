package com.quipv.app;

import com.quipv.app.DBO.SdrLiveMaintableEntity;
import com.quipv.app.Helpers.GraphHelper;
import com.quipv.app.Helpers.MaintableRepository;
import com.quipv.app.Helpers.ProjectHelper;
import com.quipv.app.Models.Graph;
import com.quipv.app.Models.GraphNode;
import com.quipv.app.Models.Project;
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

    @Before
    public void setup() {
        List<SdrLiveMaintableEntity> interiewEntries = new ArrayList<>();
        SdrLiveMaintableEntity entry1 = new SdrLiveMaintableEntity();
        entry1.setId(1);
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

        SdrLiveMaintableEntity entry2 = new SdrLiveMaintableEntity();
        entry2.setId(1);
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
        interiewEntries.add(entry1);
        interiewEntries.add(entry2);

        given(maintableRepository.findAll()).willAnswer(invocationOnMock -> interiewEntries);
    }

    @Test
    public void testGraphIsConstructedCorrectly(){
        Project project = ProjectHelper.populate(maintableRepository);
        Graph graph = GraphHelper.constructGraph(project);
        //Vertices should be D1, D2, O1, O2, O3, O4
        Assert.assertEquals(6,graph.getVertices().size());
        GraphNode D1 = graph.getNodeByName("D1").get();
        GraphNode O1 = graph.getNodeByName("O1").get();
        GraphNode O2 = graph.getNodeByName("O2").get();
        GraphNode O3 = graph.getNodeByName("O3").get();
        GraphNode O4 = graph.getNodeByName("O4").get();
        Assert.assertTrue(D1.getNeighbourNodes().contains(O1));
        Assert.assertTrue(O1.getNeighbourNodes().contains(O2));
        Assert.assertTrue(O2.getNeighbourNodes().contains(O3));
        Assert.assertTrue(O4.getNeighbourNodes().contains(O1));
    }
}
