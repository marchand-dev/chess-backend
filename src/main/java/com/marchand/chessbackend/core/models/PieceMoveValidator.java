package com.marchand.chessbackend.core.models;

import java.util.List;

public interface PieceMoveValidator {

    boolean canMove(IPiece piece, Position origin, Position destination);
    List<Position> getValidMoves(IPiece piece, Position position);

}
