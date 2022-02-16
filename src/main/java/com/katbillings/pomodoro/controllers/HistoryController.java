package com.katbillings.pomodoro.controllers;


import com.katbillings.pomodoro.data.DailyLogRepository;
import com.katbillings.pomodoro.data.HistoryRepository;
import com.katbillings.pomodoro.data.TagRepository;
import com.katbillings.pomodoro.data.UserRepository;
import com.katbillings.pomodoro.models.DailyLog;
import com.katbillings.pomodoro.models.History;
import com.katbillings.pomodoro.models.Tag;
import com.katbillings.pomodoro.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("history")
public class HistoryController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DailyLogRepository dailyLogRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private HistoryRepository historyRepository;

    @GetMapping
    public String history(Model model, @RequestParam(required = false) Integer tagId) {
        model.addAttribute("title","History");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userRepository.findByUsername(name);
        model.addAttribute("user", user);

        model.addAttribute("tags", tagRepository.findAll())
        ;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat today = new SimpleDateFormat();
        List<History> list = historyRepository.findByUser(user);
        model.addAttribute("histories", list);
        History currentHistory = null;
        for (History history : list ) {
            if (sdf.format(history.getDate()).equals(sdf.format(today))) {
                currentHistory = history;
                break;
            }
        }
        if (currentHistory == null) {
            currentHistory = new History(today, user);
        }
        model.addAttribute("history", currentHistory);
        model.addAttribute("counter", currentHistory.getCounter());
        return "history";
    }


}
