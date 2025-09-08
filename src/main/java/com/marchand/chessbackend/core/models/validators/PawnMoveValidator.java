package com.marchand.chessbackend.core.models.validators;

import com.marchand.chessbackend.core.models.IPiece;
import com.marchand.chessbackend.core.models.PieceMoveValidator;
import com.marchand.chessbackend.core.models.Position;

import java.util.List;

public class PawnMoveValidator implements PieceMoveValidator {


    @Override
    public boolean canMove(IPiece piece, Position origin, Position destination) {
        return false;
    }

    @Override
    public List<Position> getValidMoves(IPiece piece, Position position) {
        return List.of();
    }
}
