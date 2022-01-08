package com.katbillings.pomodoro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Home {

    @GetMapping
    public String hello() {
        return "index";
    }

    @GetMapping("create-account")
    public String createAccount() {
        return "create-account";
    }

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping("edit-goal")
    public String editGoal() {
        return "edit-goal";
    }

    @GetMapping("timer")
    public String timer() {
        return "timer";
    }

}
