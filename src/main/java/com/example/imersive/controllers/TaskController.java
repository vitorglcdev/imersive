package com.example.imersive.controllers;

import com.example.imersive.dto.task.TaskRequestDTO;
import com.example.imersive.dto.task.TaskResponseDTO;
import com.example.imersive.dto.task.TaskUpdateDTO;
import com.example.imersive.models.Task;
import com.example.imersive.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/task")
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> getTask(@PathVariable Long id) {
        TaskResponseDTO response = service.findById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TaskResponseDTO>> getTaskByUserId(@PathVariable Long userId) {
        List<TaskResponseDTO> response = service.findByUserId(userId);
        return ResponseEntity.ok(response); // ✅ Retornando um DTO!
    }
    //Incluir uma tarefa ou subtarefa
    @PostMapping
    public ResponseEntity<TaskResponseDTO> createTask(@RequestBody TaskRequestDTO taskDTO) {
        TaskResponseDTO response = service.createTask(taskDTO);
        return ResponseEntity.ok(response);

    }

    // Atualizar uma tarefa existente (PUT para atualizar tudo)
    @PutMapping("/{taskId}")
    public ResponseEntity<TaskResponseDTO> updateTask(@PathVariable Long taskId, @RequestBody TaskUpdateDTO taskDTO) {
        TaskResponseDTO response = service.updateTask(taskId, taskDTO);
        return ResponseEntity.ok(response);
    }
    //Deletar uma tarefa
    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId) {
        service.deleteTask(taskId);
        return ResponseEntity.noContent().build(); // ✅ Retorna 204 No Content
    }
}

