package com.katbillings.pomodoro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Home {

    @GetMapping
    public String home(Model model) {
        model.addAttribute("title","Home");
        return "index";
    }

    @GetMapping("create-account")
    public String createAccount(Model model) {
        model.addAttribute("title","Create Account");
        return "create-account";
    }

    @GetMapping("login")
    public String login(Model model) {
        model.addAttribute("title","Login");
        return "login";
    }

    @GetMapping("edit-goal")
    public String editGoal(Model model) {
        model.addAttribute("title","Edit Goal");
        return "edit-goal";
    }

    @GetMapping("timer")
    public String timer(Model model) {
        model.addAttribute("title","Timer");
        return "timer";
    }

    @GetMapping("history")
    public String history(Model model) {
        model.addAttribute("title","History");
        return "history";
    }

}
