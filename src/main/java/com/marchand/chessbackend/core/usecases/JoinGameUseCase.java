package com.marchand.chessbackend.core.usecases;

import com.marchand.chessbackend.core.dto.JoinGameResult;

import java.util.UUID;

public interface JoinGameUseCase {
    JoinGameResult execute(UUID gameId, UUID playerId);
}
