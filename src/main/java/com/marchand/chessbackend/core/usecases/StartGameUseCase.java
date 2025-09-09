package com.marchand.chessbackend.core.usecases;

import com.marchand.chessbackend.core.dto.StartGameResult;

import java.util.UUID;

public interface StartGameUseCase {
    StartGameResult execute(UUID gameId);
}
