package com.quipv.app.Helpers;

import com.opencsv.CSVReader;
import com.quipv.app.Models.MaintableEntity;
import com.quipv.app.Models.SankeyEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CsvToEntityConverter {


    public static List<MaintableEntity> getMainTableEntities(MultipartFile file){
        String username = UserHelper.getUserName();
        List<MaintableEntity> maintableEntities = new ArrayList<>();
        List<List<String>> records = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new InputStreamReader(file.getInputStream()))) {
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {
                records.add(Arrays.asList(values));
            }
        }
        catch (Exception e){
            //TODO implement this
        }

        records.remove(0);
        for(List<String> record:records){
            maintableEntities.add(getMaintableEntityFromString(record,username));
        }
        return maintableEntities;
    }

    public static List<SankeyEntity> getSankeyEntities(MultipartFile file){
        String username = UserHelper.getUserName();
        List<SankeyEntity> sankeyEntities = new ArrayList<>();
        List<List<String>> records = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new InputStreamReader(file.getInputStream()))) {
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {
                records.add(Arrays.asList(values));
            }
        }
        catch (Exception e){
            //TODO implement this
        }

        records.remove(0);
        for(List<String> record:records){
            sankeyEntities.add(getSankeyEntityFromString(record,username));
        }
        sankeyEntities = sankeyEntities.stream()
                            .filter(a -> a.getSource() != null)
                            .collect(Collectors.toList());
        return sankeyEntities;
    }

    private static MaintableEntity getMaintableEntityFromString(List<String> record, String username){
        MaintableEntity maintableEntity = new MaintableEntity();

        int row_id = Integer.parseInt(record.get(0));
        String interviewType = nullStringHelper(record.get(1));
        String respondentId = nullStringHelper(record.get(2));
        String questionId = nullStringHelper(record.get(3));
        String question = nullStringHelper(record.get(4));
        String fullAnswer = nullStringHelper(record.get(5));
        String brokenAnswer = nullStringHelper(record.get(6));
        String driverOfChange = nullStringHelper(record.get(7));
        String outcome1 = nullStringHelper(record.get(8));
        String outcome2 = nullStringHelper(record.get(9));
        String outcome3 = nullStringHelper(record.get(10));
        Integer attribution19 = null;
        try{
            attribution19 = Integer.parseInt(record.get(11));
        }catch (Exception e){}

        String domainAttributed = nullStringHelper(record.get(12));
        String respDomain = nullStringHelper(record.get(13));
        String respDriver = nullStringHelper(record.get(14));
        String respDriverDomain = nullStringHelper(record.get(15));
        String projectName = nullStringHelper(record.get(16));
        String driverDescription = nullStringHelper(record.get(17));
        String cluster = nullStringHelper(record.get(18));
        String clusterDescription = nullStringHelper(record.get(19));
        String attribution = nullStringHelper(record.get(20));
        String posNegAtribution = nullStringHelper(record.get(21));
        String attributionSummary = nullStringHelper(record.get(22));
        Integer fileinstanceId = null;
        try{
            fileinstanceId = Integer.parseInt(record.get(23));
        }catch (Exception e){}

        maintableEntity.setUploader(username);
        maintableEntity.setRowId(row_id);
        maintableEntity.setInterviewType(interviewType);
        maintableEntity.setRespondentId(respondentId);
        maintableEntity.setQuestionId(questionId);
        maintableEntity.setQuestion(question);
        maintableEntity.setFullAnswer(fullAnswer);
        maintableEntity.setBrokenAnswer(brokenAnswer);
        maintableEntity.setDriverOfChange(driverOfChange);
        maintableEntity.setOutcome1(outcome1);
        maintableEntity.setOutcome2(outcome2);
        maintableEntity.setOutcome3(outcome3);
        maintableEntity.setAttribution19(attribution19);
        maintableEntity.setDomainAttributed(domainAttributed);
        maintableEntity.setRespDomain(respDomain);
        maintableEntity.setRespDriver(respDriver);
        maintableEntity.setRespDriverDomain(respDriverDomain);
        maintableEntity.setProjectName(projectName);
        maintableEntity.setDriverDescription(driverDescription);
        maintableEntity.setCluster(cluster);
        maintableEntity.setClusterDescription(clusterDescription);
        maintableEntity.setAttribution(attribution);
        maintableEntity.setPosNegAtribution(posNegAtribution);
        maintableEntity.setAttributionSummary(attributionSummary);
        maintableEntity.setFileinstanceId(fileinstanceId);

        return maintableEntity;
    }

    private static SankeyEntity getSankeyEntityFromString(List<String> record, String username){
        SankeyEntity sankeyEntity = new SankeyEntity();

        String projectname = nullStringHelper(record.get(0));
        int rowId = Integer.parseInt(record.get(1));
        String interviewType = nullStringHelper(record.get(2));
        String source = nullStringHelper(record.get(3));
        String target = nullStringHelper(record.get(4));
        String sourceDescription = nullStringHelper(record.get(5));
        String targetDescription = nullStringHelper(record.get(6));
        int fileinstanceId = Integer.parseInt(record.get(7));
        String sourceNegPos = nullStringHelper(record.get(8));
        String targetNegPos = nullStringHelper(record.get(9));

        sankeyEntity.setUploader(username);
        sankeyEntity.setProjectname(projectname);
        sankeyEntity.setRowId(rowId);
        sankeyEntity.setInterviewType(interviewType);
        sankeyEntity.setSource(source);
        sankeyEntity.setTarget(target);
        sankeyEntity.setSourceDescription(sourceDescription);
        sankeyEntity.setTargetDescription(targetDescription);
        sankeyEntity.setFileinstanceId(fileinstanceId);
        sankeyEntity.setSourceNegPos(sourceNegPos);
        sankeyEntity.setTargetNegPos(targetNegPos);
        return sankeyEntity;
    }
    private static String nullStringHelper(String string){
        if(string.equals("NULL")){
            return null;
        }
        return string;
    }
}
