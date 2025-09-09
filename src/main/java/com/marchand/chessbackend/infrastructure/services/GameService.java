package com.marchand.chessbackend.infrastructure.services;

import com.marchand.chessbackend.core.gateways.GameServiceGateway;
import com.marchand.chessbackend.core.models.ChessGame;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class GameService implements GameServiceGateway {

    private final Map<UUID, ChessGame> activeGames = new ConcurrentHashMap<>();

    public ChessGame createGame(UUID playerId) {
        ChessGame game = new ChessGame();
        // TODO: implementar o restante
        return game;
    }

}
