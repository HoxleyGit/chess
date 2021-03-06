package com.company.commons.move;

import com.company.engine.game.chess.rule.classic.ClassicRuledPiecesBoard;

import java.util.Set;
import java.util.function.Function;

public interface IntegerCoordinatesSupplier extends Function<ClassicRuledPiecesBoard, Set<IntegerCoordinate>> {
}
