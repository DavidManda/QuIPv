package com.quipv.app;

import com.quipv.app.Models.MaintableEntity;
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
public class ProjectHelperTest {

//    @Before
//    public void setup() {
//        List<MaintableEntity> interiewEntries = new ArrayList<>();
//        MaintableEntity entry = new MaintableEntity();
//        entry.setRowId(1);
//        entry.setDriverOfChange("D1");
//        entry.setOutcome1("O1");
//        entry.setOutcome2("O2");
//        entry.setOutcome3("O3");
//        entry.setProjectName("Test project name");
//        entry.setQuestionId("QuestionID");
//        entry.setQuestion("Test question 1");
//        entry.setFullAnswer("Test full answer");
//        entry.setBrokenAnswer("Test broken answer");
//        entry.setRespondentId("Test resp ID 1");
//        entry.setInterviewType("Test interview type");
//        interiewEntries.add(entry);
//        given(maintableRepository.findAll()).willAnswer(invocationOnMock -> interiewEntries);
//    }
//
    @Test
    public void dummyTest(){
//        Iterable<MaintableEntity> interviewEntries = maintableRepository.findAll();
    }
}
