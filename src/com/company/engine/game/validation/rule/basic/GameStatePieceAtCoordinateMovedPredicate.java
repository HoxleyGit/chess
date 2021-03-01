package com.company.engine.game.validation.rule.basic;

import com.company.commons.history.GameState;
import com.company.commons.move.IntegerCoordinate;

public class GameStatePieceAtCoordinateMovedPredicate<TPiece extends BasicRuledPiece>
        implements PieceAtCoordinateMovedPredicate {

    private final GameState<TPiece> gameState;

    public GameStatePieceAtCoordinateMovedPredicate(GameState<TPiece> gameState) {
        this.gameState = gameState;
    }

    @Override
    public boolean wasPieceAtCoordinateMoved(IntegerCoordinate coordinate) {
        return gameState.wasPieceAtCoordinateMoved(coordinate);
    }
}
