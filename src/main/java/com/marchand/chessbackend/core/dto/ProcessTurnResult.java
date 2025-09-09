package com.marchand.chessbackend.core.dto;

import com.marchand.chessbackend.core.models.Move;

import java.util.UUID;

public class ProcessTurnResult {
    private UUID gameId;
    private Move move;
    private int currentTurn;
}
