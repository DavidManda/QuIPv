package com.quipv.app.Models;

import javax.persistence.*;

@Entity
@Table(name = "projects", schema = "quipv")
public class ProjectEntity {
    private int id;
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
    @Column(name = "name",nullable = false)
    public String getName() {
        return projectName;
    }

    public void setName(String name) {
        this.projectName = name;
    }
}
