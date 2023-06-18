package com.driver.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "image")
public class Image {
    public Image() {
    }

    public Image(int id, String description, String dimension, Blog blog) {
        this.id = id;
        this.description = description;
        this.dimension = dimension;
        this.blog = blog;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private String dimension;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Blog blog;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}