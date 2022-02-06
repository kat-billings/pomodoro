package com.katbillings.pomodoro.controllers;

import com.katbillings.pomodoro.data.UserRepository;
import com.katbillings.pomodoro.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("title","Home");
        return "index";
    }

    @GetMapping("create-account")
    public String createAccount(Model model) {
        model.addAttribute("title","Create Account");
        model.addAttribute(new User());
        return "create-account";
    }

    @PostMapping("create-account")
    public String processCreateAccount(@ModelAttribute @Valid User newUser, Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title","Create Account");
            return "create-account";
        }
        userRepository.save(newUser);
        model.addAttribute("createAccountSuccessful","Account created! Please login.");
        return "redirect:/login";
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
