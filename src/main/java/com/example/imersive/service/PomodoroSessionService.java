package com.example.imersive.service;

import com.example.imersive.dto.pomodorosession.PomodoroSessionRequestDTO;
import com.example.imersive.dto.pomodorosession.PomodoroSessionResponseDTO;
import com.example.imersive.dto.pomodorosession.PomodoroSessionUpdateDTO;
import com.example.imersive.dto.task.TaskResponseDTO;
import com.example.imersive.models.PomodoroSession;
import com.example.imersive.models.Task;
import com.example.imersive.models.User;
import com.example.imersive.repositories.PomodoroSessionRepository;
import com.example.imersive.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PomodoroSessionService {
    private PomodoroSessionRepository repositoryPomodoroSession;

    private UserRepository userRepository;
    public PomodoroSessionResponseDTO startSession(PomodoroSessionRequestDTO pomodoroSessionDTO){

        // Verifica se o usuário existe
        User user = userRepository.findById(pomodoroSessionDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // Cria pomodoro
        PomodoroSession pomodoroSession = new PomodoroSession();
        pomodoroSession.setEndTime(pomodoroSessionDTO.getEndTime());
        pomodoroSession.setLongBreak(pomodoroSessionDTO.getLongBreak());
        pomodoroSession.setShortBreak(pomodoroSessionDTO.getShortBreak());
        pomodoroSession.setStartTime(pomodoroSessionDTO.getStartTime());
        pomodoroSession.setWorkTime(pomodoroSessionDTO.getWorkTime());
        pomodoroSession.setUser(user);

        pomodoroSession = repositoryPomodoroSession.save(pomodoroSession);

        return new PomodoroSessionResponseDTO(pomodoroSession);
    }

    public PomodoroSessionResponseDTO updateSession(Long pomodoroSessionId, PomodoroSessionUpdateDTO pomodoroSessionDTO){
        PomodoroSession pomodoroSession= repositoryPomodoroSession.findById(pomodoroSessionId)
                .orElseThrow(() -> new RuntimeException("Sessão não encontrada"));

        if (pomodoroSessionDTO.getEndTime() != null) pomodoroSession.setEndTime(pomodoroSessionDTO.getEndTime());
        if (pomodoroSessionDTO.getLongBreak() != null) pomodoroSession.setLongBreak(pomodoroSessionDTO.getLongBreak());
        if (pomodoroSessionDTO.getShortBreak() != null) pomodoroSession.setShortBreak(pomodoroSessionDTO.getShortBreak());

        pomodoroSession = repositoryPomodoroSession.save(pomodoroSession);
        return new PomodoroSessionResponseDTO(pomodoroSession);

    }

    public List<PomodoroSessionResponseDTO> findSessionByUserID(Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        List<PomodoroSession> pomodoroSessions = repositoryPomodoroSession.findByUserId(user.getId());

        return pomodoroSessions.stream().map(PomodoroSessionResponseDTO::new).toList();
    }
}
