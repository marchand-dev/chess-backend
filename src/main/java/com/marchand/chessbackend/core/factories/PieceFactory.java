package com.marchand.chessbackend.core.factories;

import com.marchand.chessbackend.core.enums.Color;
import com.marchand.chessbackend.core.models.IPiece;
import com.marchand.chessbackend.core.models.pieces.*;

import java.util.ArrayList;
import java.util.List;

public class PieceFactory {
    public List<IPiece> createPiecesFor(Color color) {
        List<IPiece> pieces = new ArrayList<>();

        King king = new King();
        king.setColor(color);
        if (color == Color.WHITE) {
            king.setPosition();
        } else {
            king.setPosition();
        }
        pieces.add(king);

        Queen queen = new Queen();
        queen.setColor(color);
        pieces.add(queen);

        Rook rook = new Rook();
        rook.setColor(color);
        pieces.add(rook);

        for (int i = 0; i<2; i++) {
            Knight knight = new Knight();
            knight.setColor(color);
            pieces.add(knight);
        }

        for (int i = 0; i<2; i++) {
            Bishop bishop = new Bishop();
            bishop.setColor(color);
            pieces.add(bishop);
        }

        for (int i = 0; i<8; i++) {
            Pawn pawn = new Pawn();
            pawn.setColor(color);
            pieces.add(pawn);
        }

        return pieces;
    }
}
