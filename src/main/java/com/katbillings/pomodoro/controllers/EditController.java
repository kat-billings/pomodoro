package com.katbillings.pomodoro.controllers;

import com.katbillings.pomodoro.data.UserRepository;
import com.katbillings.pomodoro.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Controller
@RequestMapping("edit-goal")
public class EditController {

    @Autowired
    private UserRepository userRepository;

    @PersistenceContext
    EntityManager entityManager;

    public EditController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String editGoal(Model model) {
        model.addAttribute("title","Edit Goal");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userRepository.findByUsername(name);
        model.addAttribute("user", user);
        return "edit-goal";
    }

    @PostMapping
    String updateGoal(Model model, @RequestParam int goal) {
        model.addAttribute("title","Edit Goal");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userRepository.findByUsername(name);
        user.setGoal(goal);
        userRepository.save(user);
        return "redirect:/edit-goal?success";
    }

}
