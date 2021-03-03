package com.company.engine.game.chess.rule.classic;

import com.company.commons.move.IntegerCoordinate;
import com.company.engine.game.validation.rule.basic.BasicRuledPiece;

import java.util.Set;

public interface ClassicRuledPiece extends BasicRuledPiece {

    Set<IntegerCoordinate> getAttackedCoordinates(ClassicRuledPiecesBoard board);

    boolean isCheckable();

    boolean canCastle();

    boolean canBePromoted();
}
