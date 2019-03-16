package com.quipv.app.Models;

import javax.persistence.*;

@Entity
@Table(name = "graphnode", schema = "quipv")
public class GraphNodeEntity {
    private int id;
    private float x;
    private float y;
    private String user;
    private String projectName;

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
    @Column(name = "x",nullable = false)
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    @Basic
    @Column(name = "y",nullable = false)
    public float getY() {
        return y;
    }

    public void setY(float y) {
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
    @Column(name = "projectName",nullable = false)
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
