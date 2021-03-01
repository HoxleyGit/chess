package com.company.engine.game;

import com.company.commons.move.PlaneMove;

public interface MoveValidator {

    boolean isValid(PlaneMove planeMove);
}
