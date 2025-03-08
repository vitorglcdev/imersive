package com.example.imersive.controllers;

import com.example.imersive.dto.pomodorosession.PomodoroSessionRequestDTO;
import com.example.imersive.dto.pomodorosession.PomodoroSessionResponseDTO;
import com.example.imersive.models.PomodoroSession;
import com.example.imersive.service.PomodoroSessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
@Controller
@RequestMapping("/pomodoro")
public class PomodoroSessionController {

    private PomodoroSessionService pomodoroService;

    @PostMapping("/start")
    public ResponseEntity<PomodoroSessionResponseDTO> startSession(@RequestBody PomodoroSessionRequestDTO pomodoroSessionDTO) {
        PomodoroSessionResponseDTO response = pomodoroService.startSession(pomodoroSessionDTO);
        return ResponseEntity.ok(response);
    }
}
