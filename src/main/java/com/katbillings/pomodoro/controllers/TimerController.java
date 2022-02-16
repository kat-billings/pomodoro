package com.katbillings.pomodoro.controllers;

import com.katbillings.pomodoro.data.DailyLogRepository;
import com.katbillings.pomodoro.data.HistoryRepository;
import com.katbillings.pomodoro.data.TagRepository;
import com.katbillings.pomodoro.data.UserRepository;
import com.katbillings.pomodoro.models.DailyLog;
import com.katbillings.pomodoro.models.History;
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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("timer")
public class TimerController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private DailyLogRepository dailyLogRepository;

    @Autowired
    private HistoryRepository historyRepository;

    @PersistenceContext
    EntityManager entityManager;

    public TimerController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String timer(Model model) {
        model.addAttribute("title","Timer");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userRepository.findByUsername(name);
        model.addAttribute("user", user);
        model.addAttribute(new DailyLog());
        model.addAttribute("tags", tagRepository.findAll());
        return "timer";
    }

    @PostMapping
    String submitBlock(Model model, @ModelAttribute DailyLog log) throws ParseException {
        model.addAttribute("title","Timer");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userRepository.findByUsername(name);
        dailyLogRepository.save(log);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat today = new SimpleDateFormat();
        List<History> list = historyRepository.findByUser(user);
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
        currentHistory.setCounter(currentHistory.getCounter() + 1);
        return "redirect:/timer?break";
    }
//    @PostMapping
//    String updateGoal(Model model, @RequestParam int goal) {
//        model.addAttribute("title","Timer");
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String name = auth.getName();
//        User user = userRepository.findByUsername(name);
//        long id = user.getId();
//        DailyLog log = new DailyLog(new Tag("tag"));
//        log.addToCounter();
//        Date today = new Date();
//        History history = new History(today, (List<DailyLog>) log);
//        user.setHistory((List<History>) history);
//        userRepository.save(user);
//        return "redirect:/edit-goal?success";
//    }

}
