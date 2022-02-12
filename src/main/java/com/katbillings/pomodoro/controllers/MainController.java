package com.katbillings.pomodoro.controllers;

import com.katbillings.pomodoro.data.UserRepository;
import com.katbillings.pomodoro.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("title","Home");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userRepository.findByUsername(name);
        model.addAttribute("user", user);
        return "index";
    }

    @GetMapping("login")
    public String login(Model model) {
        model.addAttribute("title","Login");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userRepository.findByUsername(name);
        model.addAttribute("user", user);
        return "login";
    }

    @GetMapping("timer")
    public String timer(Model model) {
        model.addAttribute("title","Timer");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userRepository.findByUsername(name);
        model.addAttribute("user", user);
        return "timer";
    }

    @GetMapping("history")
    public String history(Model model) {
        model.addAttribute("title","History");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userRepository.findByUsername(name);
        model.addAttribute("user", user);
        return "history";
    }

}
