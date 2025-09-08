package com.marchand.chessbackend.core.models;

public class Position {

    private int col;
    private int row;
    private IPiece piece;

    public Position(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public IPiece getPiece() {
        return piece;
    }

    public void setPiece(IPiece piece) {
        this.piece = piece;
    }

    public static Position fromAlgebraic(String notation) {
        int col = notation.charAt(0) - 'a';
        int row = 8 - Character.getNumericValue(notation.charAt(1)); // '8' → 0, '1' → 7
        return new Position(row, col);
    }

    public String toAlgebraic() {
        return "" + (char)('a' + col) + (8 - row);
    }

}
