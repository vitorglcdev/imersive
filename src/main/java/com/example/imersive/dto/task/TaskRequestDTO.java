package com.example.imersive.dto.task;

import com.example.imersive.models.User;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

public class TaskRequestDTO {
    private String title;
    private String description;
    private Boolean completed;
    private Long parentTaskId; // Se for uma subtarefa
    private Date startTime; // Data e hora de início
    private Date endTime; // Data e hora de término
    private Long userId;

    public TaskRequestDTO(String description, String title, boolean completed, Long parentTaskId, Date startTime, Date endTime, Long userId) {
        this.description = description;
        this.title = title;
        this.completed = completed;
        this.parentTaskId = parentTaskId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.userId = userId;
    }

    public Long getUserId() {return userId;}

    public void setUserId(Long userId) {this.userId = userId;}

    public Date getEndTime() {return endTime;}

    public void setEndTime(Date endTime) {this.endTime = endTime;}

    public Date getStartTime() {return startTime;}

    public void setStartTime(Date startTime) {this.startTime = startTime;}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {return description;}

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }


    public Boolean isCompleted( ){
        if(this.getCompleted()){
            return true;
        }else{
            return false;
        }
    }
    public Long getParentTaskId() {
        return parentTaskId;
    }

    public void setParentTaskId(Long parentTaskId) {
        this.parentTaskId = parentTaskId;
    }
}