package com.quipv.app.Models;

import javax.persistence.*;

@Entity
@Table(name = "nodes", schema = "quipv")
public class GraphNodeEntity {
    private int id;
    private int nodeIndex;
    private Float x;
    private Float y;
    private String user;
    private String name;
    private boolean isDriver;
    private boolean isChecked;
    private int projectId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GraphNodeEntity(){}

    public GraphNodeEntity(String user, String name, int projectId, int index, boolean isDriver, boolean isChecked) {
        this.isChecked = isChecked;
        this.user = user;
        this.name = name;
        this.projectId = projectId;
        this.nodeIndex = index;
        this.isDriver =  isDriver;
    }

    @Basic
    @Column(name = "x")
    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }

    @Basic
    @Column(name = "y")
    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
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
    @Column(name = "projectId",nullable = false)
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    @Basic
    @Column(name = "name",nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "nodeIndex",nullable = false)
    public int getNodeIndex() {
        return nodeIndex;
    }

    public void setNodeIndex(int index) {
        this.nodeIndex = index;
    }

    @Basic
    @Column(name = "isDriver",nullable = false)
    public boolean isDriver() {
        return isDriver;
    }

    public void setDriver(boolean driver) {
        isDriver = driver;
    }

    @Basic
    @Column(name = "isChecked",nullable = false)
    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}


