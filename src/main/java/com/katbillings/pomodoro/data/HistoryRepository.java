package com.katbillings.pomodoro.data;

import com.katbillings.pomodoro.models.History;
import com.katbillings.pomodoro.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History, Integer> {
    List<History> findByUser(User user);

}
