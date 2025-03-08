package com.example.imersive.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class PomodoroSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // Relacionamento com usuário
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private Integer workTime;  // Tempo de foco (minutos)
    private Integer shortBreak;
    private Integer longBreak;


    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUserId() {
        return user;
    }

    public void setUserId(User user) {
        this.user = user;
    }

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Integer workTime) {
        this.workTime = workTime;
    }

    public Integer getShortBreak() {
        return shortBreak;
    }

    public void setShortBreak(Integer shortBreak) {
        this.shortBreak = shortBreak;
    }

    public Integer getLongBreak() {
        return longBreak;
    }

    public void setLongBreak(Integer longBreak) {this.longBreak = longBreak;}

    public Date getStartTime() {return startTime;}

    public void setStartTime(Date startTime) {this.startTime = startTime;}

    public Date getEndTime() {return endTime;}

    public void setEndTime(Date endTime) {this.endTime = endTime;}

    // Getters e Setters
}
