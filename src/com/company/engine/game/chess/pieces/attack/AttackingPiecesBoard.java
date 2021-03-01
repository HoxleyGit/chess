package com.company.engine.game.chess.pieces.attack;

import com.company.commons.move.IntegerCoordinate;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiece;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiecesBoard;

import java.util.Optional;

public interface AttackingPiecesBoard extends ClassicRuledPiecesBoard {

    Optional<IntegerCoordinate> getCoordinateOf(ClassicRuledPiece piece);

    boolean isCoordinateFound(IntegerCoordinate coordinate);
}
