package com.company.engine.game;

import com.company.commons.history.GameState;
import com.company.commons.history.MovesHistory;
import com.company.commons.move.IntegerCoordinate;
import com.company.engine.game.chess.chessboard.ClassicChessboard;
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
        var board = new ClassicChessboard();
        var gameState = new GameState<>(movesHistory, board);
        var pieceAtCoordinateMovedPredicate = new GameStatePieceAtCoordinateMovedPredicate<>(gameState);
        board.placePiecesAtRow(() -> new Pawn(true, board, pieceAtCoordinateMovedPredicate), 6);
        board.placePiecesAtRow(() -> new Pawn(false, board, pieceAtCoordinateMovedPredicate), 1);
        board.placePiecesColumnMirroring(
                () -> new Rook(true, board), new IntegerCoordinate(7, 0));
        board.placePiecesColumnMirroring(
                () -> new Rook(false, board), new IntegerCoordinate(0, 7));
        board.placePiecesColumnMirroring(
                () -> new ClassicKnight(true, board), new IntegerCoordinate(7, 1));
        board.placePiecesColumnMirroring(
                () -> new ClassicKnight(false, board), new IntegerCoordinate(0, 1));
        board.placePiecesColumnMirroring(
                () -> new ClassicBishop(true, board), new IntegerCoordinate(7, 2));
        board.placePiecesColumnMirroring(
                () -> new ClassicBishop(false, board), new IntegerCoordinate(0, 2));
        board.placePiece(new Queen(true, board), new IntegerCoordinate(7, 3));
        board.placePiece(new Queen(false, board), new IntegerCoordinate(0, 3));
        board.placePiece(
                new ClassicKing(true, board, pieceAtCoordinateMovedPredicate),
                new IntegerCoordinate(7, 4));
        board.placePiece(
                new ClassicKing(false, board, pieceAtCoordinateMovedPredicate),
                new IntegerCoordinate(0, 4));
        return board;
    }
}
