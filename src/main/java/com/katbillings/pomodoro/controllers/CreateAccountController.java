package com.katbillings.pomodoro.controllers;

import com.katbillings.pomodoro.data.UserRepository;
import com.katbillings.pomodoro.dto.UserRegistrationDto;
import com.katbillings.pomodoro.models.User;
import com.katbillings.pomodoro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/create-account")
public class CreateAccountController {

    @Autowired
    private UserRepository userRepository;

    private UserService userService;

    public CreateAccountController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String createAccount(Model model) {
        model.addAttribute("title","Create Account");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userRepository.findByUsername(name);
        model.addAttribute("user", user);
        model.addAttribute("user", new UserRegistrationDto());
        return "create-account";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
        userService.save(registrationDto);
        return "redirect:/create-account?success";
    }
}
