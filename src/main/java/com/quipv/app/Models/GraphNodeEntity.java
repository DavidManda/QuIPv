package com.quipv.app.Models;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "nodes", schema = "quipv")
//@NamedQuery(name = "GraphNodeEntity.findByName", query = "SELECT n FROM GraphNodeEntity n WHERE n.user = ?1")
public class GraphNodeEntity {
    private int id;
    private int index;
    private Float x;
    private Float y;
    private String user;
    private String name;
    private boolean isDriver;
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

    public GraphNodeEntity(String user, String name, int projectId, int index, boolean isDriver){
        this.user = user;
        this.name = name;
        this.projectId = projectId;
        this.index = index;
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
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Basic
    @Column(name = "isDriver",nullable = false)
    public boolean isDriver() {
        return isDriver;
    }

    public void setDriver(boolean driver) {
        isDriver = driver;
    }
}


