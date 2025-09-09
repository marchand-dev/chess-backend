package com.marchand.chessbackend.core.dto;

import java.util.UUID;

public class StartGameResult {
    private UUID gameId;

    public StartGameResult() {
    }

    public UUID getGameId() {
        return gameId;
    }
}
