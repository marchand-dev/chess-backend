package com.marchand.chessbackend.infrastructure.controllers;

import com.marchand.chessbackend.core.dto.JoinGameResult;
import com.marchand.chessbackend.core.dto.CreateGameResult;
import com.marchand.chessbackend.core.dto.ProcessTurnResult;
import com.marchand.chessbackend.core.dto.StartGameResult;
import com.marchand.chessbackend.core.usecases.JoinGameUseCase;
import com.marchand.chessbackend.core.usecases.CreateGameUseCase;
import com.marchand.chessbackend.core.usecases.ProcessTurnUseCase;
import com.marchand.chessbackend.core.usecases.StartGameUseCase;
import com.marchand.chessbackend.infrastructure.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// TODO: refatorar controller de modo que os metodos fiquem divididos em varios controllers,
//  cada um com apenas um metodo e responsabilidade

@RestController
@RequestMapping("/api/v1/game")
public class ChessGameController {

    @Autowired
    private CreateGameUseCase createGameUseCase;

    @Autowired
    private JoinGameUseCase joinGameUseCase;

    @Autowired
    private StartGameUseCase startGameUseCase;

    @Autowired
    private ProcessTurnUseCase processTurnUseCase;

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

    @PostMapping("/processturn")
    public ResponseEntity<ProcessTurnResponse> processTurn(@RequestBody ProcessTurnRequest request) {
        try {
            ProcessTurnResult result = processTurnUseCase.execute(request.getMove());
            ProcessTurnResponse response = new ProcessTurnResponse(result, false, "");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ProcessTurnResponse response = new ProcessTurnResponse(null, true, e.getMessage());
            return ResponseEntity.ok(response);
        }
    }
}
