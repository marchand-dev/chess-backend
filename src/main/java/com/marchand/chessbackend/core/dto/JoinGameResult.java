package com.marchand.chessbackend.core.dto;

import java.util.UUID;

public class JoinGameResult {
    private UUID gameId;
    private UUID playerId;

    public JoinGameResult(UUID gameId, UUID playerId) {
        this.gameId = gameId;
        this.playerId = playerId;
    }

    public UUID getGameId() {
        return gameId;
    }

    public UUID getPlayerId() {
        return playerId;
    }
}
