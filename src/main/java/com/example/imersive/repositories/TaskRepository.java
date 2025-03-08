package com.example.imersive.repositories;

import com.example.imersive.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository <Task, Long> {
    List<Task> findByUserId(Long userId);
}
