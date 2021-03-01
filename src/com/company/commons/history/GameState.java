package com.company.commons.history;

import com.company.commons.move.IntegerCoordinate;

public class GameState<TPiece> {

    private final MovesHistory<TPiece> movesHistory;

    private final GameStateBoard<TPiece> gameStateBoard;

    public GameState(MovesHistory<TPiece> movesHistory, GameStateBoard<TPiece> gameStateBoard) {
        this.movesHistory = movesHistory;
        this.gameStateBoard = gameStateBoard;
    }

    public boolean wasPieceAtCoordinateMoved(IntegerCoordinate coordinate) {
        return gameStateBoard.getPiece(coordinate).map(movesHistory::wasPieceMoved).orElse(false);
    }
}
