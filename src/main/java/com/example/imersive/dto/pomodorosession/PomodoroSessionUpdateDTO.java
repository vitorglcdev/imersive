package com.example.imersive.dto.pomodorosession;

import com.example.imersive.models.PomodoroSession;

import java.util.Date;

public class PomodoroSessionUpdateDTO {
    private Integer workTime;  // Tempo de foco (minutos)
    private Integer shortBreak;
    private Integer longBreak;
    private Integer completedCycles;
    private Date startTime;
    private Date endTime;

    public PomodoroSessionUpdateDTO(PomodoroSession pomodoroSession) {}

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

    public Integer getCompletedCycles() {
        return completedCycles;
    }

    public void setCompletedCycles(Integer completedCycles) {
        this.completedCycles = completedCycles;
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
