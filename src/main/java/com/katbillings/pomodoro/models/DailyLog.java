package com.katbillings.pomodoro.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "daily_log")
public class DailyLog extends AbstractEntity {

    @ManyToOne
    private History  history;

    @ManyToOne
    private Tag tag;

    public DailyLog(Tag tag) {
        this.tag = tag;
    }

    public DailyLog() {};

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }
}
