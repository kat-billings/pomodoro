package com.katbillings.pomodoro.controllers;

import com.katbillings.pomodoro.data.TagRepository;
import com.katbillings.pomodoro.data.UserRepository;
import com.katbillings.pomodoro.models.Tag;
import com.katbillings.pomodoro.models.User;
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
@RequestMapping("create-tag")
public class CreateTagController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TagRepository tagRepository;

    @GetMapping
    public String createTag(Model model) {
        model.addAttribute("title","Create Tag");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userRepository.findByUsername(name);
        model.addAttribute("user", user);
        model.addAttribute(new Tag());
        return "create-tag";
    }

    @PostMapping
    public String submitTag(Model model, @ModelAttribute Tag tag) {
        model.addAttribute("title","Create Tag");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userRepository.findByUsername(name);
        model.addAttribute("user", user);
        tagRepository.save(tag);
        return "redirect:create-tag?success";
    }

}
