package com.company.engine.game.validation.rule.basic;

import com.company.commons.move.IntegerCoordinate;
import com.company.engine.game.validation.rule.MoveRuledBoard;

import java.util.Optional;
import java.util.Set;

public interface BasicRuledPiecesBoard<TPiece extends BasicRuledPiece> extends MoveRuledBoard<TPiece> {

    Optional<TPiece> getPiece(IntegerCoordinate coordinate);

    Set<IntegerCoordinate> getOccupiedCoordinates();
}
