package com.marchand.chessbackend.core.models;

import com.marchand.chessbackend.core.enums.Color;

import java.util.List;
import java.util.UUID;

public class Player {

    private UUID playerId;
    private String name;
    private Color color;

    public Color getColor() {
        return color;
    }

}
