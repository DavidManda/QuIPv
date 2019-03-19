package com.quipv.app.Models;
import javax.persistence.*;

@Entity
@Table(name = "edges", schema = "quipv")
public class EdgeEntity {
    private int id;
    private int sourceIndex;
    private int destinationIndex;
    private int weight;
    private String user;
    private int projectId;

    public EdgeEntity(){}

    public EdgeEntity(int sourceIndex, int destinationIndex, int weight, int projectId, String user){
        this.sourceIndex = sourceIndex;
        this.destinationIndex = destinationIndex;
        this.weight = weight;
        this.projectId = projectId;
        this.user = user;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user",nullable = false)
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Basic
    @Column(name = "sourceId",nullable = false)
    public int getSourceIndex() {
        return sourceIndex;
    }

    public void setSourceIndex(int sourceId) {
        this.sourceIndex = sourceId;
    }

    @Basic
    @Column(name = "destinationId",nullable = false)
    public int getDestinationIndex() {
        return destinationIndex;
    }

    public void setDestinationIndex(int destinationId) {
        this.destinationIndex = destinationId;
    }

    @Basic
    @Column(name = "weight",nullable = false)
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "projectId",nullable = false)
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
}
