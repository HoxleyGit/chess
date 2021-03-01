package com.company.engine.game;

import com.company.commons.move.PlaneMove;

public interface BadMoveObserver {

    void onBadMove(PlaneMove move, String violation);
}
