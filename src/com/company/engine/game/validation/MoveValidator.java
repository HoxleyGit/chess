package com.company.engine.game.validation;

import com.company.commons.move.PlaneMove;

public interface MoveValidator {

    boolean isValid(PlaneMove planeMove);
}
