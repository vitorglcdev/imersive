package com.example.imersive.dto.pomodorosession;

import java.util.Date;

public class PomodoroSessionRequestDTO {

    private Integer workTime;  // Tempo de foco (minutos)
    private Integer shortBreak;
    private Integer longBreak;
    private Date startTime;
    private Date endTime;
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getWorkTime() {
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

    public void setLongBreak(Integer longBreak) {
        this.longBreak = longBreak;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
