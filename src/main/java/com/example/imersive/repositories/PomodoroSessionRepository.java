package com.example.imersive.repositories;

import com.example.imersive.models.PomodoroSession;
import com.example.imersive.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PomodoroSessionRepository extends JpaRepository<PomodoroSession, Long> {
    List<PomodoroSession> findByUserId(Long userId);
}
