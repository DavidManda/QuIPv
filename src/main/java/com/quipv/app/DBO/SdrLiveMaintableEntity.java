package com.quipv.app.DBO;

import javax.persistence.*;

@Entity
@Table(name = "sdr_live_maintable", schema = "quipv")
public class SdrLiveMaintableEntity {
    private Integer sourceFileinstanceId;
    private Integer rowId;
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
    private String attribution19;
    private String domainAttributed;
    private String respDomain;
    private String respDriver;
    private String respDriverDomain;
    private String projectName;
    private Integer fileinstanceId;
    private Integer parentFileinstanceId;

    @Basic
    @Column(name = "SourceFileinstanceID")
    public Integer getSourceFileinstanceId() {
        return sourceFileinstanceId;
    }

    public void setSourceFileinstanceId(Integer sourceFileinstanceId) {
        this.sourceFileinstanceId = sourceFileinstanceId;
    }

    @Basic
    @Column(name = "row_id")
    public Integer getRowId() {
        return rowId;
    }

    public void setRowId(Integer rowId) {
        this.rowId = rowId;
    }

    @Basic
    @Column(name = "InterviewType")
    public String getInterviewType() {
        return interviewType;
    }

    public void setInterviewType(String interviewType) {
        this.interviewType = interviewType;
    }

    @Basic
    @Column(name = "Respondent_ID")
    public String getRespondentId() {
        return respondentId;
    }

    public void setRespondentId(String respondentId) {
        this.respondentId = respondentId;
    }

    @Basic
    @Column(name = "Question_ID")
    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    @Basic
    @Column(name = "Question")
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Basic
    @Column(name = "Full_Answer")
    public String getFullAnswer() {
        return fullAnswer;
    }

    public void setFullAnswer(String fullAnswer) {
        this.fullAnswer = fullAnswer;
    }

    @Basic
    @Column(name = "Broken_Answer")
    public String getBrokenAnswer() {
        return brokenAnswer;
    }

    public void setBrokenAnswer(String brokenAnswer) {
        this.brokenAnswer = brokenAnswer;
    }

    @Basic
    @Column(name = "Driver_of_Change")
    public String getDriverOfChange() {
        return driverOfChange;
    }

    public void setDriverOfChange(String driverOfChange) {
        this.driverOfChange = driverOfChange;
    }

    @Basic
    @Column(name = "Outcome_1")
    public String getOutcome1() {
        return outcome1;
    }

    public void setOutcome1(String outcome1) {
        this.outcome1 = outcome1;
    }

    @Basic
    @Column(name = "Outcome_2")
    public String getOutcome2() {
        return outcome2;
    }

    public void setOutcome2(String outcome2) {
        this.outcome2 = outcome2;
    }

    @Basic
    @Column(name = "Outcome_3")
    public String getOutcome3() {
        return outcome3;
    }

    public void setOutcome3(String outcome3) {
        this.outcome3 = outcome3;
    }

    @Basic
    @Column(name = "Attribution__1_9")
    public String getAttribution19() {
        return attribution19;
    }

    public void setAttribution19(String attribution19) {
        this.attribution19 = attribution19;
    }

    @Basic
    @Column(name = "Domain_Attributed")
    public String getDomainAttributed() {
        return domainAttributed;
    }

    public void setDomainAttributed(String domainAttributed) {
        this.domainAttributed = domainAttributed;
    }

    @Basic
    @Column(name = "RespDomain")
    public String getRespDomain() {
        return respDomain;
    }

    public void setRespDomain(String respDomain) {
        this.respDomain = respDomain;
    }

    @Basic
    @Column(name = "RespDriver")
    public String getRespDriver() {
        return respDriver;
    }

    public void setRespDriver(String respDriver) {
        this.respDriver = respDriver;
    }

    @Basic
    @Column(name = "RespDriverDomain")
    public String getRespDriverDomain() {
        return respDriverDomain;
    }

    public void setRespDriverDomain(String respDriverDomain) {
        this.respDriverDomain = respDriverDomain;
    }

    @Basic
    @Column(name = "ProjectName")
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Basic
    @Column(name = "FileinstanceID")
    public Integer getFileinstanceId() {
        return fileinstanceId;
    }

    public void setFileinstanceId(Integer fileinstanceId) {
        this.fileinstanceId = fileinstanceId;
    }

    @Basic
    @Column(name = "ParentFileinstanceID")
    public Integer getParentFileinstanceId() {
        return parentFileinstanceId;
    }

    public void setParentFileinstanceId(Integer parentFileinstanceId) {
        this.parentFileinstanceId = parentFileinstanceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SdrLiveMaintableEntity that = (SdrLiveMaintableEntity) o;

        if (sourceFileinstanceId != null ? !sourceFileinstanceId.equals(that.sourceFileinstanceId) : that.sourceFileinstanceId != null)
            return false;
        if (rowId != null ? !rowId.equals(that.rowId) : that.rowId != null) return false;
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
        if (fileinstanceId != null ? !fileinstanceId.equals(that.fileinstanceId) : that.fileinstanceId != null)
            return false;
        if (parentFileinstanceId != null ? !parentFileinstanceId.equals(that.parentFileinstanceId) : that.parentFileinstanceId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sourceFileinstanceId != null ? sourceFileinstanceId.hashCode() : 0;
        result = 31 * result + (rowId != null ? rowId.hashCode() : 0);
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
        result = 31 * result + (fileinstanceId != null ? fileinstanceId.hashCode() : 0);
        result = 31 * result + (parentFileinstanceId != null ? parentFileinstanceId.hashCode() : 0);
        return result;
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;


}
