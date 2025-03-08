package com.example.imersive.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;


@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @Column(nullable = false)
    private Boolean completed;
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime; // Data e hora de início

    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime; // Data e hora de término

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // Relacionamento com usuário
    private User user;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Task parentTask; // Tarefa Pai

    @OneToMany(mappedBy = "parentTask", cascade = CascadeType.ALL)
    private List<Task> subtasks; // Lista de Subtarefas
    public List<Task> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(List<Task> subtasks) {
        this.subtasks = subtasks;
    }

    public Task getParentTask() {
        return parentTask;
    }

    public void setParentTask(Task parentTask) {
        this.parentTask = parentTask;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() { return id;
    }

    // Getters e Setters
}
