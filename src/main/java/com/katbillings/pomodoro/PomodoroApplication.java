package com.katbillings.pomodoro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Timer;

@SpringBootApplication
public class PomodoroApplication {

	public static void main(String[] args) {
		SpringApplication.run(PomodoroApplication.class, args);
	}

	public static int timer() {
		return 0;
	}

}
