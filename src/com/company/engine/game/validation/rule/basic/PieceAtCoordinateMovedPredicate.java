package com.company.engine.game.validation.rule.basic;

import com.company.commons.move.IntegerCoordinate;

public interface PieceAtCoordinateMovedPredicate {

    boolean wasPieceAtCoordinateMoved(IntegerCoordinate coordinate);
}
