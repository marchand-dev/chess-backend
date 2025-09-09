package com.marchand.chessbackend.core.usecases.impl;

import com.marchand.chessbackend.core.dto.CreateGameResult;
import com.marchand.chessbackend.core.gateways.GameServiceGateway;
import com.marchand.chessbackend.core.models.ChessGame;
import com.marchand.chessbackend.core.usecases.CreateGameUseCase;

import java.util.UUID;

public class CreateGameUseCaseImpl implements CreateGameUseCase {

    private GameServiceGateway gameServiceGateway;

    @Override
    public CreateGameResult execute(UUID playerId) {
        if (playerId == null || playerId.toString().isEmpty()) {
            throw new RuntimeException("invalid player id");
        }

        ChessGame chessGame = gameServiceGateway.createGame(playerId);

        return new CreateGameResult(chessGame.getGameId());
    }
}
