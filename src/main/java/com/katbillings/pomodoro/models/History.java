package com.katbillings.pomodoro.models;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "history")
public class History extends AbstractEntity{

    private SimpleDateFormat date;

    @OneToMany(mappedBy = "history")
    private final List<DailyLog> log = new ArrayList<>();

    @ManyToOne
    private User user;

    private int counter;

    public History(SimpleDateFormat date, User user) {
        this.date = date;
        this.user = user;
        this.counter = 0;
    }

    public History() {};

    public void addToCounter() {
        this.counter++;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }


    public SimpleDateFormat getDate() {
        return date;
    }

    public void setDate(SimpleDateFormat date) {
        this.date = date;
    }

    public List<DailyLog> getLog() {
        return log;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
