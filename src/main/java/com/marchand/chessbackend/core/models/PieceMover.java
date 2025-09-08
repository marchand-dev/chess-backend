package com.marchand.chessbackend.core.models;

public interface PieceMover {
    void move(IPiece piece, Position origin, Position destination);

}
