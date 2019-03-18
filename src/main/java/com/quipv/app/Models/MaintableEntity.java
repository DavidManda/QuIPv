package com.quipv.app.Models;

public class MaintableEntity {
    private int id;
    private int rowId;
    private String interviewType;
    private String respondentId;
    private String questionId;
    private String question;
    private String fullAnswer;
    private String brokenAnswer;
    private String driverOfChange;
    private String outcome1;
    private String outcome2;
    private String outcome3;
    private Integer attribution19;
    private String domainAttributed;
    private String respDomain;
    private String respDriver;
    private String respDriverDomain;
    private String projectName;
    private String driverDescription;
    private String cluster;
    private String clusterDescription;
    private String attribution;
    private String posNegAtribution;
    private String attributionSummary;
    private int fileinstanceId;
    private String uploader;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRowId() {
        return rowId;
    }

    public void setRowId(int rowId) {
        this.rowId = rowId;
    }

    public String getInterviewType() {
        return interviewType;
    }

    public void setInterviewType(String interviewType) {
        this.interviewType = interviewType;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public String getRespondentId() {
        return respondentId;
    }

    public void setRespondentId(String respondentId) {
        this.respondentId = respondentId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getFullAnswer() {
        return fullAnswer;
    }

    public void setFullAnswer(String fullAnswer) {
        this.fullAnswer = fullAnswer;
    }

    public String getBrokenAnswer() {
        return brokenAnswer;
    }

    public void setBrokenAnswer(String brokenAnswer) {
        this.brokenAnswer = brokenAnswer;
    }

    public String getDriverOfChange() {
        return driverOfChange;
    }

    public void setDriverOfChange(String driverOfChange) {
        this.driverOfChange = driverOfChange;
    }

    public String getOutcome1() {
        return outcome1;
    }

    public void setOutcome1(String outcome1) {
        this.outcome1 = outcome1;
    }

    public String getOutcome2() {
        return outcome2;
    }

    public void setOutcome2(String outcome2) {
        this.outcome2 = outcome2;
    }

    public String getOutcome3() {
        return outcome3;
    }

    public void setOutcome3(String outcome3) {
        this.outcome3 = outcome3;
    }

    public Integer getAttribution19() {
        return attribution19;
    }

    public void setAttribution19(Integer attribution19) {
        this.attribution19 = attribution19;
    }

    public String getDomainAttributed() {
        return domainAttributed;
    }

    public void setDomainAttributed(String domainAttributed) {
        this.domainAttributed = domainAttributed;
    }

    public String getRespDomain() {
        return respDomain;
    }

    public void setRespDomain(String respDomain) {
        this.respDomain = respDomain;
    }

    public String getRespDriver() {
        return respDriver;
    }

    public void setRespDriver(String respDriver) {
        this.respDriver = respDriver;
    }

    public String getRespDriverDomain() {
        return respDriverDomain;
    }

    public void setRespDriverDomain(String respDriverDomain) {
        this.respDriverDomain = respDriverDomain;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDriverDescription() {
        return driverDescription;
    }

    public void setDriverDescription(String driverDescription) {
        this.driverDescription = driverDescription;
    }

    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
    }

    public String getClusterDescription() {
        return clusterDescription;
    }

    public void setClusterDescription(String clusterDescription) {
        this.clusterDescription = clusterDescription;
    }

    public String getAttribution() {
        return attribution;
    }

    public void setAttribution(String attribution) {
        this.attribution = attribution;
    }

    public String getPosNegAtribution() {
        return posNegAtribution;
    }

    public void setPosNegAtribution(String posNegAtribution) {
        this.posNegAtribution = posNegAtribution;
    }

    public String getAttributionSummary() {
        return attributionSummary;
    }

    public void setAttributionSummary(String attributionSummary) {
        this.attributionSummary = attributionSummary;
    }

    public int getFileinstanceId() {
        return fileinstanceId;
    }

    public void setFileinstanceId(int fileinstanceId) {
        this.fileinstanceId = fileinstanceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaintableEntity that = (MaintableEntity) o;

        if (rowId != that.rowId) return false;
        if (fileinstanceId != that.fileinstanceId) return false;
        if (interviewType != null ? !interviewType.equals(that.interviewType) : that.interviewType != null)
            return false;
        if (respondentId != null ? !respondentId.equals(that.respondentId) : that.respondentId != null) return false;
        if (questionId != null ? !questionId.equals(that.questionId) : that.questionId != null) return false;
        if (question != null ? !question.equals(that.question) : that.question != null) return false;
        if (fullAnswer != null ? !fullAnswer.equals(that.fullAnswer) : that.fullAnswer != null) return false;
        if (brokenAnswer != null ? !brokenAnswer.equals(that.brokenAnswer) : that.brokenAnswer != null) return false;
        if (driverOfChange != null ? !driverOfChange.equals(that.driverOfChange) : that.driverOfChange != null)
            return false;
        if (outcome1 != null ? !outcome1.equals(that.outcome1) : that.outcome1 != null) return false;
        if (outcome2 != null ? !outcome2.equals(that.outcome2) : that.outcome2 != null) return false;
        if (outcome3 != null ? !outcome3.equals(that.outcome3) : that.outcome3 != null) return false;
        if (attribution19 != null ? !attribution19.equals(that.attribution19) : that.attribution19 != null)
            return false;
        if (domainAttributed != null ? !domainAttributed.equals(that.domainAttributed) : that.domainAttributed != null)
            return false;
        if (respDomain != null ? !respDomain.equals(that.respDomain) : that.respDomain != null) return false;
        if (respDriver != null ? !respDriver.equals(that.respDriver) : that.respDriver != null) return false;
        if (respDriverDomain != null ? !respDriverDomain.equals(that.respDriverDomain) : that.respDriverDomain != null)
            return false;
        if (projectName != null ? !projectName.equals(that.projectName) : that.projectName != null) return false;
        if (driverDescription != null ? !driverDescription.equals(that.driverDescription) : that.driverDescription != null)
            return false;
        if (cluster != null ? !cluster.equals(that.cluster) : that.cluster != null) return false;
        if (clusterDescription != null ? !clusterDescription.equals(that.clusterDescription) : that.clusterDescription != null)
            return false;
        if (attribution != null ? !attribution.equals(that.attribution) : that.attribution != null) return false;
        if (posNegAtribution != null ? !posNegAtribution.equals(that.posNegAtribution) : that.posNegAtribution != null)
            return false;
        if (attributionSummary != null ? !attributionSummary.equals(that.attributionSummary) : that.attributionSummary != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rowId;
        result = 31 * result + (interviewType != null ? interviewType.hashCode() : 0);
        result = 31 * result + (respondentId != null ? respondentId.hashCode() : 0);
        result = 31 * result + (questionId != null ? questionId.hashCode() : 0);
        result = 31 * result + (question != null ? question.hashCode() : 0);
        result = 31 * result + (fullAnswer != null ? fullAnswer.hashCode() : 0);
        result = 31 * result + (brokenAnswer != null ? brokenAnswer.hashCode() : 0);
        result = 31 * result + (driverOfChange != null ? driverOfChange.hashCode() : 0);
        result = 31 * result + (outcome1 != null ? outcome1.hashCode() : 0);
        result = 31 * result + (outcome2 != null ? outcome2.hashCode() : 0);
        result = 31 * result + (outcome3 != null ? outcome3.hashCode() : 0);
        result = 31 * result + (attribution19 != null ? attribution19.hashCode() : 0);
        result = 31 * result + (domainAttributed != null ? domainAttributed.hashCode() : 0);
        result = 31 * result + (respDomain != null ? respDomain.hashCode() : 0);
        result = 31 * result + (respDriver != null ? respDriver.hashCode() : 0);
        result = 31 * result + (respDriverDomain != null ? respDriverDomain.hashCode() : 0);
        result = 31 * result + (projectName != null ? projectName.hashCode() : 0);
        result = 31 * result + (driverDescription != null ? driverDescription.hashCode() : 0);
        result = 31 * result + (cluster != null ? cluster.hashCode() : 0);
        result = 31 * result + (clusterDescription != null ? clusterDescription.hashCode() : 0);
        result = 31 * result + (attribution != null ? attribution.hashCode() : 0);
        result = 31 * result + (posNegAtribution != null ? posNegAtribution.hashCode() : 0);
        result = 31 * result + (attributionSummary != null ? attributionSummary.hashCode() : 0);
        result = 31 * result + fileinstanceId;
        return result;
    }
}
