package com.marchand.chessbackend.core.usecases;

import com.marchand.chessbackend.core.dto.CreateGameResult;

import java.util.UUID;

public interface CreateGameUseCase {
    CreateGameResult execute(UUID playerId);
}
