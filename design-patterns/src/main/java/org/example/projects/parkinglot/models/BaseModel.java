package org.example.projects.parkinglot.models;

import java.time.LocalDateTime;

public abstract class BaseModel {
    private int id;
    private LocalDateTime createdAt;
    private LocalDateTime updateddAt;

    private String createdBy;
    private String updatedBy;


    public BaseModel(){

    }

    public BaseModel(int id, LocalDateTime createdAt, LocalDateTime updateddAt, String createdBy, String updatedBy) {
        this.id = id;
        this.createdAt = createdAt;
        this.updateddAt = updateddAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdateddAt() {
        return updateddAt;
    }

    public void setUpdateddAt(LocalDateTime updateddAt) {
        this.updateddAt = updateddAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
