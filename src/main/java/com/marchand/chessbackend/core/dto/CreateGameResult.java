package com.marchand.chessbackend.core.dto;

import java.util.UUID;

public class CreateGameResult {
    private UUID gameId;

    /*public CreateGameResult() {
    }*/

    public CreateGameResult(UUID gameId) {
        this.gameId = gameId;
    }

    public UUID getGameId() {
        return gameId;
    }

    /*public void setGameId(UUID gameId) {
        this.gameId = gameId;
    }*/
}
