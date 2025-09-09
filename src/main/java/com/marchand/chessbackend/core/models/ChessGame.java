package com.marchand.chessbackend.core.models;

import com.marchand.chessbackend.core.enums.Color;
import com.marchand.chessbackend.core.factories.PieceFactory;
import com.marchand.chessbackend.core.models.movers.PieceMoverOrchestrator;
import com.marchand.chessbackend.core.models.validators.PieceMoveValidatorOrchestrator;

import java.util.UUID;

public class ChessGame {
    private UUID gameId;
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private PieceFactory pieceFactory;
    private PieceMoverOrchestrator pieceMoverOrchestrator;
    private PieceMoveValidatorOrchestrator pieceMoveValidatorOrchestrator;
    private int currentTurn = 0;

    public ChessGame() {
    }

    public ChessGame(Board board, Player player1, Player player2, PieceFactory pieceFactory,
                     PieceMoverOrchestrator pieceMoverOrchestrator, PieceMoveValidatorOrchestrator pieceMoveValidatorOrchestrator) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.pieceFactory = pieceFactory;
        this.pieceMoverOrchestrator = pieceMoverOrchestrator;
        this.pieceMoveValidatorOrchestrator = pieceMoveValidatorOrchestrator;
    }

    public void setupGame() {
        if (player1 == null) {
            throw new RuntimeException("Player 1 cant be null");
        }

        if (player2 == null) {
            throw new RuntimeException("Player 2 cant be null");
        }

        if (board == null) {
            throw new RuntimeException("Board cant be null");
        }

        board.setPieces(pieceFactory.createPiecesFor(Color.WHITE));
        board.setPieces(pieceFactory.createPiecesFor(Color.BLACK));
        pieceMoverOrchestrator.setBoard(board);
        pieceMoveValidatorOrchestrator.setBoard(board);
        //setupPieces() ou prepareBoard()

        if (board.getPieces() == null) {
            throw new RuntimeException("Pieces cant be null");
        }

        if (board.getPieces().size() != 32) {
            throw new RuntimeException("Board must have 32 pieces for the game to start");
        }

        setCurrentPlayer(player1);
    }

    public void startGame() {

    }

    public void ProcessPlayerTurn(Player player, IPiece piece, Position origin, Position destination) {
        // check can move
        // move
        if (!pieceMoveValidatorOrchestrator.canMove(piece, origin, destination)) {
            throw new RuntimeException("Cant move to destination position");
        }

        pieceMoverOrchestrator.move(piece, origin, destination);
        // remove dead piece from board
        // verify check
        // verify checkmate
        // check winner
        // etc etc
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    private void setCurrentPlayer(Player p) {
        currentPlayer = p;
    }

    private void setupPieces() {
        //
    }

    public UUID getGameId() {
        return gameId;
    }

    public void setGameId(UUID gameId) {
        this.gameId = gameId;
    }

    private void incTurn() {
        currentTurn = currentTurn + 1;
    }
}
