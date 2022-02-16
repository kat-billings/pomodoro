package com.katbillings.pomodoro.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tags")
public class Tag extends AbstractEntity{

    private String name;

    @OneToMany(mappedBy = "tag")
    private final List<DailyLog> logs = new ArrayList<>();

    public Tag(String name) {
        this.name = name;
    }

    public Tag() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DailyLog> getLogs() {
        return logs;
    }
}
