package com.marchand.chessbackend.infrastructure.controllers;

import com.marchand.chessbackend.core.dto.CreateGameResult;
import com.marchand.chessbackend.core.usecases.CreateGameUseCase;
import com.marchand.chessbackend.infrastructure.dto.CreateGameRequest;
import com.marchand.chessbackend.infrastructure.dto.CreateGameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/game")
public class CreateGameController {
    @Autowired
    private CreateGameUseCase createGameUseCase;

    @PostMapping("/create")
    public ResponseEntity<CreateGameResponse> createGame(@RequestBody CreateGameRequest request) {
        try {
            // leio request
            // crio game
            // retorno o id
            CreateGameResult result = createGameUseCase.execute(request.getPlayerId());
            CreateGameResponse response = new CreateGameResponse(result.getGameId(), false, "");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            CreateGameResponse response = new CreateGameResponse(null, true, e.getMessage());
            return ResponseEntity.ok(response);
        }
    }
}
