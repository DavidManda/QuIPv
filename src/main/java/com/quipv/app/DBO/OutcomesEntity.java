package com.quipv.app.DBO;

import javax.persistence.*;

@Entity
@Table(name = "outcomes", schema = "quipv", catalog = "")
public class OutcomesEntity {
    private int id;
    private String outcomeNegPos;
    private String projectname;
    private int rowId;
    private String interviewType;
    private String outcome;
    private String outcomeType;
    private int fileinstanceId;
    private String description;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "OutcomeNegPos", nullable = false, length = 16)
    public String getOutcomeNegPos() {
        return outcomeNegPos;
    }

    public void setOutcomeNegPos(String outcomeNegPos) {
        this.outcomeNegPos = outcomeNegPos;
    }

    @Basic
    @Column(name = "projectname", nullable = false, length = 7)
    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    @Basic
    @Column(name = "row_id", nullable = false)
    public int getRowId() {
        return rowId;
    }

    public void setRowId(int rowId) {
        this.rowId = rowId;
    }

    @Basic
    @Column(name = "interviewType", nullable = false, length = 18)
    public String getInterviewType() {
        return interviewType;
    }

    public void setInterviewType(String interviewType) {
        this.interviewType = interviewType;
    }

    @Basic
    @Column(name = "Outcome", nullable = true, length = 4)
    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    @Basic
    @Column(name = "outcomeType", nullable = false, length = 9)
    public String getOutcomeType() {
        return outcomeType;
    }

    public void setOutcomeType(String outcomeType) {
        this.outcomeType = outcomeType;
    }

    @Basic
    @Column(name = "FileinstanceID", nullable = false)
    public int getFileinstanceId() {
        return fileinstanceId;
    }

    public void setFileinstanceId(int fileinstanceId) {
        this.fileinstanceId = fileinstanceId;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 33)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OutcomesEntity that = (OutcomesEntity) o;

        if (id != that.id) return false;
        if (rowId != that.rowId) return false;
        if (fileinstanceId != that.fileinstanceId) return false;
        if (outcomeNegPos != null ? !outcomeNegPos.equals(that.outcomeNegPos) : that.outcomeNegPos != null)
            return false;
        if (projectname != null ? !projectname.equals(that.projectname) : that.projectname != null) return false;
        if (interviewType != null ? !interviewType.equals(that.interviewType) : that.interviewType != null)
            return false;
        if (outcome != null ? !outcome.equals(that.outcome) : that.outcome != null) return false;
        if (outcomeType != null ? !outcomeType.equals(that.outcomeType) : that.outcomeType != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (outcomeNegPos != null ? outcomeNegPos.hashCode() : 0);
        result = 31 * result + (projectname != null ? projectname.hashCode() : 0);
        result = 31 * result + rowId;
        result = 31 * result + (interviewType != null ? interviewType.hashCode() : 0);
        result = 31 * result + (outcome != null ? outcome.hashCode() : 0);
        result = 31 * result + (outcomeType != null ? outcomeType.hashCode() : 0);
        result = 31 * result + fileinstanceId;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
