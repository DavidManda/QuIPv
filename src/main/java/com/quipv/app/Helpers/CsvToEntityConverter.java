package com.quipv.app.Helpers;

import com.opencsv.CSVReader;
import com.quipv.app.Models.MaintableEntity;

import java.io.FileReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvToEntityConverter {
    public static List<MaintableEntity> getMainTableEntities(Path path){
        List<MaintableEntity> maintableEntities = new ArrayList<>();
        List<List<String>> records = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(path.toString()));) {
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
            maintableEntities.add(getMaintableEntityFromString(record));
        }
        return maintableEntities;
    }

    private static MaintableEntity getMaintableEntityFromString(List<String> record){
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

    private static String nullStringHelper(String string){
        if(string.equals("NULL")){
            return null;
        }
        return string;
    }
}
