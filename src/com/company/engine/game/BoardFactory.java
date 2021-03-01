package com.company.engine.game;

import com.company.commons.board.SquareBoard;
import com.company.commons.history.GameState;
import com.company.commons.history.MovesHistory;
import com.company.commons.move.IntegerCoordinate;
import com.company.engine.game.chess.infrastructure.ClassicChessboard;
import com.company.engine.game.chess.pieces.*;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiece;
import com.company.engine.game.history.ArchivedMovesBoard;
import com.company.engine.game.validation.rule.MoveRuledValidator;
import com.company.engine.game.validation.rule.basic.GameStatePieceAtCoordinateMovedPredicate;

import java.util.ArrayList;

public class BoardFactory {

    public ObservableBoard createMovesGame(GameType gameType) {
        return switch (gameType) {
            case CLASSIC_CHESS -> createClassicChessGame();
        };
    }

    private ObservableBoard createClassicChessGame() {
        var movesHistory = new MovesHistory<ClassicRuledPiece>();
        var classicChessboard = createAndSetupClassicChessboard(movesHistory);
        return new ValidatedBoard(
                new ArchivedMovesBoard<>(classicChessboard, movesHistory),
                new MoveRuledValidator<>(classicChessboard),
                new ArrayList<>());
    }

    private ClassicChessboard createAndSetupClassicChessboard(MovesHistory<ClassicRuledPiece> movesHistory) {
        var squareBoard = new SquareBoard<ClassicRuledPiece>(8, 8);
        var board = new ClassicChessboard(squareBoard);
        var gameState = new GameState<>(movesHistory, board);
        var pieceAtCoordinateMovedPredicate = new GameStatePieceAtCoordinateMovedPredicate<>(gameState);
        squareBoard.placePiecesAtRow(() -> new Pawn(true, board, pieceAtCoordinateMovedPredicate), 6);
        squareBoard.placePiecesAtRow(() -> new Pawn(false, board, pieceAtCoordinateMovedPredicate), 1);
        squareBoard.placePiecesColumnMirroring(
                () -> new Rook(true, board), new IntegerCoordinate(7, 0));
        squareBoard.placePiecesColumnMirroring(
                () -> new Rook(false, board), new IntegerCoordinate(0, 7));
        squareBoard.placePiecesColumnMirroring(
                () -> new ClassicKnight(true, board), new IntegerCoordinate(7, 1));
        squareBoard.placePiecesColumnMirroring(
                () -> new ClassicKnight(false, board), new IntegerCoordinate(0, 1));
        squareBoard.placePiecesColumnMirroring(
                () -> new ClassicBishop(true, board), new IntegerCoordinate(7, 2));
        squareBoard.placePiecesColumnMirroring(
                () -> new ClassicBishop(false, board), new IntegerCoordinate(0, 2));
        squareBoard.placePiece(new Queen(true, board), new IntegerCoordinate(7, 3));
        squareBoard.placePiece(new Queen(false, board), new IntegerCoordinate(0, 3));
        squareBoard.placePiece(
                new ClassicKing(true, board, pieceAtCoordinateMovedPredicate),
                new IntegerCoordinate(7, 4));
        squareBoard.placePiece(
                new ClassicKing(false, board, pieceAtCoordinateMovedPredicate),
                new IntegerCoordinate(0, 4));
        return board;
    }
}
