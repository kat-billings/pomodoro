package com.katbillings.pomodoro.service;

import com.katbillings.pomodoro.dto.UserRegistrationDto;
import com.katbillings.pomodoro.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
