package com.marchand.chessbackend.infrastructure.controllers;

import com.marchand.chessbackend.core.dto.ProcessTurnResult;
import com.marchand.chessbackend.core.usecases.ProcessTurnUseCase;
import com.marchand.chessbackend.infrastructure.dto.ProcessTurnRequest;
import com.marchand.chessbackend.infrastructure.dto.ProcessTurnResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ProcessTurnController {
    @Autowired
    private ProcessTurnUseCase processTurnUseCase;

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
