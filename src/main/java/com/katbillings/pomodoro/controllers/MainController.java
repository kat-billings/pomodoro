package com.katbillings.pomodoro.controllers;

import com.katbillings.pomodoro.data.HistoryRepository;
import com.katbillings.pomodoro.data.UserRepository;
import com.katbillings.pomodoro.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    HistoryRepository historyRepository;

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

}
