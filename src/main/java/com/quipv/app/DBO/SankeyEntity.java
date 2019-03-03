package com.quipv.app.DBO;

import javax.persistence.*;

@Entity
@Table(name = "sankey", schema = "quipv", catalog = "")
public class SankeyEntity {
    private int id;
    private String projectname;
    private int rowId;
    private String interviewType;
    private String source;
    private String target;
    private String sourceDescription;
    private String targetDescription;
    private int fileinstanceId;
    private String sourceNegPos;
    private String targetNegPos;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "Source", nullable = true, length = 4)
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Basic
    @Column(name = "Target", nullable = true, length = 4)
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Basic
    @Column(name = "SourceDescription", nullable = true, length = 38)
    public String getSourceDescription() {
        return sourceDescription;
    }

    public void setSourceDescription(String sourceDescription) {
        this.sourceDescription = sourceDescription;
    }

    @Basic
    @Column(name = "TargetDescription", nullable = true, length = 32)
    public String getTargetDescription() {
        return targetDescription;
    }

    public void setTargetDescription(String targetDescription) {
        this.targetDescription = targetDescription;
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
    @Column(name = "SourceNegPos", nullable = false, length = 16)
    public String getSourceNegPos() {
        return sourceNegPos;
    }

    public void setSourceNegPos(String sourceNegPos) {
        this.sourceNegPos = sourceNegPos;
    }

    @Basic
    @Column(name = "TargetNegPos", nullable = false, length = 16)
    public String getTargetNegPos() {
        return targetNegPos;
    }

    public void setTargetNegPos(String targetNegPos) {
        this.targetNegPos = targetNegPos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SankeyEntity that = (SankeyEntity) o;

        if (id != that.id) return false;
        if (rowId != that.rowId) return false;
        if (fileinstanceId != that.fileinstanceId) return false;
        if (projectname != null ? !projectname.equals(that.projectname) : that.projectname != null) return false;
        if (interviewType != null ? !interviewType.equals(that.interviewType) : that.interviewType != null)
            return false;
        if (source != null ? !source.equals(that.source) : that.source != null) return false;
        if (target != null ? !target.equals(that.target) : that.target != null) return false;
        if (sourceDescription != null ? !sourceDescription.equals(that.sourceDescription) : that.sourceDescription != null)
            return false;
        if (targetDescription != null ? !targetDescription.equals(that.targetDescription) : that.targetDescription != null)
            return false;
        if (sourceNegPos != null ? !sourceNegPos.equals(that.sourceNegPos) : that.sourceNegPos != null) return false;
        if (targetNegPos != null ? !targetNegPos.equals(that.targetNegPos) : that.targetNegPos != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (projectname != null ? projectname.hashCode() : 0);
        result = 31 * result + rowId;
        result = 31 * result + (interviewType != null ? interviewType.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (target != null ? target.hashCode() : 0);
        result = 31 * result + (sourceDescription != null ? sourceDescription.hashCode() : 0);
        result = 31 * result + (targetDescription != null ? targetDescription.hashCode() : 0);
        result = 31 * result + fileinstanceId;
        result = 31 * result + (sourceNegPos != null ? sourceNegPos.hashCode() : 0);
        result = 31 * result + (targetNegPos != null ? targetNegPos.hashCode() : 0);
        return result;
    }
}
