package com.marchand.chessbackend.core.models.pieces;

import com.marchand.chessbackend.core.enums.Color;

public abstract class Piece {

    private Color color;

    public void setColor(Color c) {
        color = c;
    }

}
