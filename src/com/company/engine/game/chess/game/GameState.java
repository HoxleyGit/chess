package com.company.engine.game.chess.game;

import com.company.engine.game.chess.chessboard.ClassicChessboard;
import com.company.engine.game.chess.chessboard.ChessboardCoordinate;
import com.company.commons.history.MovesHistory;

public class GameState {

    private final ClassicChessboard classicChessboard;

    private final MovesHistory movesHistory;

    public GameState(ClassicChessboard classicChessboard, MovesHistory movesHistory) {
        this.classicChessboard = classicChessboard;
        this.movesHistory = movesHistory;
    }

    public boolean wasPieceAtCoordinateMoved(ChessboardCoordinate coordinate) {
        return movesHistory.wasPieceMoved(classicChessboard.getPiece(coordinate).orElseThrow());
    }
}
