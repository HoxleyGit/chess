package com.company.engine.game.validation.rule;

import com.company.commons.move.IntegerCoordinate;
import com.company.engine.game.Board;

import java.util.Optional;

public interface MoveRuledBoard<TPiece extends MoveRuledPiece> extends Board {

    Optional<TPiece> getPiece(IntegerCoordinate point);
}
