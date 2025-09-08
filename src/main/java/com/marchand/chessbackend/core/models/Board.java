package com.marchand.chessbackend.core.models;
import com.marchand.chessbackend.core.enums.Color;
import com.marchand.chessbackend.core.enums.PieceStatus;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Position> positions;
    private List<IPiece> pieces;

    public Board() {
        positions = new ArrayList<>();
        setupBoard();
    }

    private void setupBoard() {
        //popula tabuleiro com as 64 posições
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                positions.add(new Position(i, j));
            }
        }
    }

    public void setPieces(List<IPiece> pieces) {
        this.pieces = pieces;
    }

    public List<IPiece> getPieces() {
        return pieces;
    }

    public List<IPiece> getActivePieces() {
        return pieces.stream().filter(piece -> piece.getStatus() == PieceStatus.ACTIVE).toList();
    }

    public List<IPiece> getActivePiecesByColor(Color c) {
        return pieces.stream().
                filter(piece -> piece.getStatus() == PieceStatus.ACTIVE).
                filter(piece -> piece.getColor() == c).
                toList();
    }

    public List<IPiece> getInactivePieces() {
        return pieces.stream().filter(piece -> piece.getStatus() == PieceStatus.INACTIVE).toList();
    }

    public List<IPiece> getInactivePiecesByColor(Color c) {
        return pieces.stream().
                filter(piece -> piece.getStatus() == PieceStatus.INACTIVE).
                filter(piece -> piece.getColor() == c).
                toList();
    }
}
