package com.katbillings.pomodoro.data;

import com.katbillings.pomodoro.models.DailyLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyLogRepository extends CrudRepository<DailyLog, Integer> {
}
