package com.marchand.chessbackend.infrastructure.controllers;


import com.marchand.chessbackend.core.dto.JoinGameResult;
import com.marchand.chessbackend.core.usecases.JoinGameUseCase;
import com.marchand.chessbackend.infrastructure.dto.JoinGameRequest;
import com.marchand.chessbackend.infrastructure.dto.JoinGameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/game")
public class JoinGameController {

    @Autowired
    private JoinGameUseCase joinGameUseCase;

    @PostMapping("/join")
    public ResponseEntity<JoinGameResponse> joinGame(@RequestBody JoinGameRequest request) {
        try {
            JoinGameResult result = joinGameUseCase.execute(request.getGameId(), request.getPlayerId());
            JoinGameResponse response = new JoinGameResponse(result.getGameId(), result.getPlayerId(), false, "");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            JoinGameResponse response = new JoinGameResponse(null, null, true, e.getMessage());
            return ResponseEntity.ok(response);
        }
    }
}
