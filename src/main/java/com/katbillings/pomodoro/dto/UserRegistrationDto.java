package com.katbillings.pomodoro.dto;

import com.katbillings.pomodoro.models.History;

public class UserRegistrationDto {
    private String username;
    private String password;
    private int goal;
    private History history;

    public UserRegistrationDto() {

    }

    public UserRegistrationDto(String username, String password, int goal, History history) {
        this.username = username;
        this.password = password;
        this.goal = goal;
        this.history = history;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }
}
