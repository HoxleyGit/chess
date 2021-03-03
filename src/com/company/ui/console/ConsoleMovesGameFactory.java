package com.company.ui.console;

import com.company.commons.board.SquareBoard;
import com.company.commons.history.GameState;
import com.company.commons.history.MovesHistory;
import com.company.commons.move.IntegerCoordinate;
import com.company.engine.game.MemorableBoard;
import com.company.engine.game.MoveMadeObservableBoard;
import com.company.engine.game.ValidatedBoardBadMove;
import com.company.engine.game.chess.infrastructure.ClassicChessboard;
import com.company.engine.game.chess.pieces.*;
import com.company.engine.game.chess.rule.classic.ClassicKingCastleMoveObserver;
import com.company.engine.game.chess.rule.classic.ClassicRuledBoardMemoryMovesHistory;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiece;
import com.company.engine.game.chess.rule.classic.ClassicSimplePromotionMoveObserver;
import com.company.engine.game.history.ArchivedMovesBoard;
import com.company.engine.game.validation.rule.MoveRuledValidator;
import com.company.engine.game.validation.rule.basic.GameStatePieceAtCoordinateMovedPredicate;

import java.util.ArrayList;
import java.util.function.Supplier;

public class ConsoleMovesGameFactory {

    ConsoleMovesGame createConsoleMovesGame(ConsoleMovesGameType gameType) {
        return switch (gameType) {
            case CLASSIC_CHESS -> createClassicChessConsoleMovesGame();
        };
    }

    private ConsoleMovesGame createClassicChessConsoleMovesGame() {
        var movesHistory = new MovesHistory<ClassicRuledPiece>();
        var classicChessboard = createAndSetupClassicChessboard(movesHistory);
        var classicRuledBoardMemoryMovesHistory = new ClassicRuledBoardMemoryMovesHistory();
        var moveMadeObservableBoard = new MoveMadeObservableBoard(new MemorableBoard(classicChessboard, classicRuledBoardMemoryMovesHistory, movesHistory), new ArrayList<>());
        moveMadeObservableBoard.subscribe(new ClassicKingCastleMoveObserver(classicChessboard, movesHistory, classicRuledBoardMemoryMovesHistory));
        moveMadeObservableBoard.subscribe(new ClassicSimplePromotionMoveObserver(classicChessboard, classicRuledBoardMemoryMovesHistory, isWhite -> new Queen(isWhite, classicChessboard, movesHistory::countMoves)));
        var validatedBoard = new ValidatedBoardBadMove(
                new ArchivedMovesBoard<>(
                        moveMadeObservableBoard, classicChessboard, movesHistory),
                new MoveRuledValidator<>(classicChessboard),
                new ArrayList<>());
        return new ClassicChessConsoleMovesGame(validatedBoard, moveMadeObservableBoard, new ClassicChessMoveMapper());
    }

    private ClassicChessboard createAndSetupClassicChessboard(MovesHistory<ClassicRuledPiece> movesHistory) {
        var squareBoard = new SquareBoard<ClassicRuledPiece>(8, 8);
        var board = new ClassicChessboard(squareBoard);
        var gameState = new GameState<>(movesHistory, board);
        Supplier<Integer> movesCountSupplier = movesHistory::countMoves;
        var pieceAtCoordinateMovedPredicate = new GameStatePieceAtCoordinateMovedPredicate<>(gameState);
        squareBoard.placePiecesAtRow(() ->
                new Pawn(true, board, pieceAtCoordinateMovedPredicate, movesCountSupplier), 6);
        squareBoard.placePiecesAtRow(() ->
                new Pawn(false, board, pieceAtCoordinateMovedPredicate, movesCountSupplier), 1);
        squareBoard.placePiecesColumnMirroring(
                () -> new Rook(true, board, movesCountSupplier), new IntegerCoordinate(7, 0));
        squareBoard.placePiecesColumnMirroring(
                () -> new Rook(false, board, movesCountSupplier), new IntegerCoordinate(0, 7));
        squareBoard.placePiecesColumnMirroring(
                () -> new ClassicKnight(true, board, movesCountSupplier), new IntegerCoordinate(7, 1));
        squareBoard.placePiecesColumnMirroring(
                () -> new ClassicKnight(false, board, movesCountSupplier), new IntegerCoordinate(0, 1));
        squareBoard.placePiecesColumnMirroring(
                () -> new ClassicBishop(true, board, movesCountSupplier), new IntegerCoordinate(7, 2));
        squareBoard.placePiecesColumnMirroring(
                () -> new ClassicBishop(false, board, movesCountSupplier), new IntegerCoordinate(0, 2));
        squareBoard.placePiece(new Queen(true, board, movesCountSupplier), new IntegerCoordinate(7, 3));
        squareBoard.placePiece(new Queen(false, board, movesCountSupplier), new IntegerCoordinate(0, 3));
        squareBoard.placePiece(
                new ClassicKing(true, board, pieceAtCoordinateMovedPredicate, movesCountSupplier),
                new IntegerCoordinate(7, 4));
        squareBoard.placePiece(
                new ClassicKing(false, board, pieceAtCoordinateMovedPredicate, movesCountSupplier),
                new IntegerCoordinate(0, 4));
        return board;
    }
}
