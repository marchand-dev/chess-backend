package com.marchand.chessbackend.core.models;

import java.util.UUID;

public class Move {
    private UUID gameId;
    private UUID playerId;
    private IPiece piece;
    private Position position;
}
