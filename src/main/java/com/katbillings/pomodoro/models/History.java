//package com.katbillings.pomodoro.models;
//
//import javax.persistence.*;
//import java.util.Collection;
//import java.util.Date;
//
//@Entity
//@Table(name = "history")
//public class History {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private Date date;
//
//    @JoinColumn(name = "log", referencedColumnName = "id")
//    private Collection<DailyLog> log;
//
////    public History(Date date, Collection<DailyLog> log) {
////        this.date = date;
////        this.log = log;
////    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//
//    public Collection<DailyLog> getLog() {
//        return log;
//    }
//
//    public void setLog(Collection<DailyLog> log) {
//        this.log = log;
//    }
//}
