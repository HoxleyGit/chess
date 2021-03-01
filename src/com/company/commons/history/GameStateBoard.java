package com.company.commons.history;

import com.company.commons.move.IntegerCoordinate;

import java.util.Optional;

public interface GameStateBoard<TPiece> {

    Optional<TPiece> getPiece(IntegerCoordinate coordinate);
}
