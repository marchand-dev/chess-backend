package com.marchand.chessbackend.core.models.movers;

import com.marchand.chessbackend.core.models.Board;
import com.marchand.chessbackend.core.models.IPiece;
import com.marchand.chessbackend.core.models.PieceMover;
import com.marchand.chessbackend.core.models.Position;

public class PieceMoverOrchestrator {

    private Board board;
    private PawnMover pawnMover;
    private RookMover rookMover;
    private KnightMover knightMover;
    private BishopMover bishopMover;
    private QueenMover queenMover;
    private KingMover kingMover;

    public PieceMoverOrchestrator(Board board,
                                  PawnMover pawnMover,
                                  RookMover rookMover,
                                  KnightMover knightMover,
                                  BishopMover bishopMover,
                                  QueenMover queenMover,
                                  KingMover kingMover) {
        this.board = board;
        this.pawnMover = pawnMover;
        this.rookMover = rookMover;
        this.knightMover = knightMover;
        this.bishopMover = bishopMover;
        this.queenMover = queenMover;
        this.kingMover = kingMover;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void move(IPiece piece, Position origin, Position destination) {
        PieceMover pieceMover = getPieceMover(piece);
    }

    private PieceMover getPieceMover(IPiece piece) {
        return switch (piece.getType()) {
            case PAWN -> pawnMover;
            case KNIGHT -> knightMover;
            case BISHOP -> bishopMover;
            case ROOK -> rookMover;
            case QUEEN -> queenMover;
            case KING -> kingMover;
        };
    }
}
