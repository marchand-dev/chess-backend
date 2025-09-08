package com.marchand.chessbackend.core.models;

import com.marchand.chessbackend.core.enums.Color;
import com.marchand.chessbackend.core.enums.PieceStatus;
import com.marchand.chessbackend.core.enums.PieceType;

public interface IPiece {

    Color getColor();
    PieceType getType();
    PieceStatus getStatus();

}
