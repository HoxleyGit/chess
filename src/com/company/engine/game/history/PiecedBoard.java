package com.company.engine.game.history;

import com.company.commons.move.IntegerCoordinate;
import com.company.engine.game.Board;

import java.util.Optional;

public interface PiecedBoard<TPiece> extends Board {

    Optional<TPiece> getPiece(IntegerCoordinate coordinate);
}
