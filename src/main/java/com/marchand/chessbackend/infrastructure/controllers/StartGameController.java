package com.marchand.chessbackend.infrastructure.controllers;

import com.marchand.chessbackend.core.dto.StartGameResult;
import com.marchand.chessbackend.core.usecases.StartGameUseCase;
import com.marchand.chessbackend.infrastructure.dto.StartGameRequest;
import com.marchand.chessbackend.infrastructure.dto.StartGameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/game")
public class StartGameController {
    @Autowired
    private StartGameUseCase startGameUseCase;

    @PostMapping("/start")
    public ResponseEntity<StartGameResponse> startGame(@RequestBody StartGameRequest request) {
        try {
            StartGameResult result = startGameUseCase.execute(request.getGameId());
            StartGameResponse response = new StartGameResponse(result.getGameId(), false, "");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            StartGameResponse response = new StartGameResponse(null, true, e.getMessage());
            return ResponseEntity.ok(response);
        }
    }
}
