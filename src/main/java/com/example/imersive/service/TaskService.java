package com.example.imersive.service;

import com.example.imersive.dto.task.TaskRequestDTO;
import com.example.imersive.dto.task.TaskResponseDTO;
import com.example.imersive.dto.task.TaskUpdateDTO;
import com.example.imersive.models.Task;
import com.example.imersive.models.User;
import com.example.imersive.repositories.TaskRepository;
import com.example.imersive.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;

    // Atualizar uma tarefa existente
    public TaskResponseDTO updateTask(Long taskId, TaskUpdateDTO taskDTO) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        if (taskDTO.getTitle() != null) task.setTitle(taskDTO.getTitle());
        if (taskDTO.getDescription() != null) task.setDescription(taskDTO.getDescription());
        if (taskDTO.isCompleted()) task.setCompleted(taskDTO.getCompleted());

        task = taskRepository.save(task);
        return new TaskResponseDTO(task);
    }

    public TaskResponseDTO createTask(TaskRequestDTO taskDTO) {
        // Verifica se o usuário existe
        User user = userRepository.findById(taskDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // Se for uma subtarefa, busca a tarefa pai
        Task parentTask = null;
        if (taskDTO.getParentTaskId() != null) {
            parentTask = taskRepository.findById(taskDTO.getParentTaskId())
                    .orElseThrow(() -> new RuntimeException("Tarefa pai não encontrada"));
        }

        // Cria a tarefa
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setCompleted(taskDTO.getCompleted());
        task.setUser(user);
        task.setParentTask(parentTask);

        // Salva a tarefa no banco
        task = taskRepository.save(task);

        return new TaskResponseDTO(task);
    }

    // Buscar tarefa por ID do usuario
    public List<TaskResponseDTO> findByUserId(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        List<Task> tasks = taskRepository.findByUserId(userId); // ✅ Apenas pega a lista, sem Optional

        if (tasks.isEmpty()) {
            throw new RuntimeException("Nenhuma tarefa encontrada para este usuário");
        }

        return tasks.stream().map(TaskResponseDTO::new).toList();
    }

    // Buscar tarefa por ID
    public TaskResponseDTO findById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        return new TaskResponseDTO(task);
    }

    // Deletar tarefa por ID
    public void deleteTask(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        taskRepository.delete(task); // ✅ Deleta a tarefa do banco de dados
    }


}

