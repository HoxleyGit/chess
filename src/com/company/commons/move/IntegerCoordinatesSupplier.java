package com.company.commons.move;

import com.company.engine.game.chess.rule.classic.ClassicRuledPiecesBoard;

import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

public interface IntegerCoordinatesSupplier extends Function<ClassicRuledPiecesBoard, Set<IntegerCoordinate>> {
}
