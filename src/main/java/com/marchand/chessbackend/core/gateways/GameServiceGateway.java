package com.marchand.chessbackend.core.gateways;

import com.marchand.chessbackend.core.models.ChessGame;

import java.util.UUID;

public interface GameServiceGateway {

    ChessGame createGame(UUID playerId);

}
