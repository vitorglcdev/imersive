package com.example.imersive.dto.task;
import jakarta.persistence.Column;
import com.example.imersive.models.Task;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TaskResponseDTO {
        private String title;
        private String description;
        private Boolean completed;
        private List<TaskResponseDTO> subtasks;
        private Date startTime; // Data e hora de início
        private Date endTime; // Data e hora de término
        private Long userId;

    public TaskResponseDTO(Date endTime, String title, String description, boolean completed, List<TaskResponseDTO> subtasks, Date startTime, Long UserId) {
        this.endTime = endTime;
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.subtasks = subtasks;
        this.startTime = startTime;
        this.userId = userId;
    }


    public TaskResponseDTO(Task task) {}
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {this.userId = userId;}

    public Date getEndTime() {return endTime;}

    public void setEndTime(Date endTime) {this.endTime = endTime;}
    public Date getStartTime() {return startTime;}

    public void setStartTime(Date startTime) {this.startTime = startTime;}

    public List<TaskResponseDTO> getSubtasks() {return subtasks;}

    public void setSubtasks(List<TaskResponseDTO> subtasks) {this.subtasks = subtasks;}

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Boolean isCompleted( ){
        if(this.getCompleted()){
            return true;
        }else{
            return false;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {this.title = title;}
}
