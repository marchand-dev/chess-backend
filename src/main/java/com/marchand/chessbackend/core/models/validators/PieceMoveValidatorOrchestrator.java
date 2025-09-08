package com.marchand.chessbackend.core.models.validators;

import com.marchand.chessbackend.core.models.Board;
import com.marchand.chessbackend.core.models.IPiece;
import com.marchand.chessbackend.core.models.PieceMoveValidator;
import com.marchand.chessbackend.core.models.Position;
import com.marchand.chessbackend.core.models.movers.*;

import java.util.List;

public class PieceMoveValidatorOrchestrator {

    private Board board;
    private PawnMoveValidator pawnMoveValidator;
    private RookMoveValidator rookMoveValidator;
    private KnightMoveValidator knightMoveValidator;
    private BishopMoveValidator bishopMoveValidator;
    private QueenMoveValidator queenMoveValidator;
    private KingMoveValidator kingMoveValidator;

    public PieceMoveValidatorOrchestrator(Board board,
                                          PawnMoveValidator pawnMoveValidator,
                                          RookMoveValidator rookMoveValidator,
                                          KnightMoveValidator knightMoveValidator,
                                          BishopMoveValidator bishopMoveValidator,
                                          QueenMoveValidator queenMoveValidator,
                                          KingMoveValidator kingMoveValidator) {
        this.board = board;
        this.pawnMoveValidator = pawnMoveValidator;
        this.rookMoveValidator = rookMoveValidator;
        this.knightMoveValidator = knightMoveValidator;
        this.bishopMoveValidator = bishopMoveValidator;
        this.queenMoveValidator = queenMoveValidator;
        this.kingMoveValidator = kingMoveValidator;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public boolean canMove(IPiece piece, Position origin, Position destination) {
        PieceMoveValidator validator = getValidator(piece);
        return validator.canMove(piece, origin, destination);
    }

    public List<Position> getValidMoves(IPiece piece, Position position) {
        PieceMoveValidator validator = getValidator(piece);
        return validator.getValidMoves(piece, position);
    }

    private PieceMoveValidator getValidator(IPiece piece) {
        return switch (piece.getType()) {
            case PAWN -> pawnMoveValidator;
            case KNIGHT -> knightMoveValidator;
            case BISHOP -> bishopMoveValidator;
            case ROOK -> rookMoveValidator;
            case QUEEN -> queenMoveValidator;
            case KING -> kingMoveValidator;
        };

    }
}
