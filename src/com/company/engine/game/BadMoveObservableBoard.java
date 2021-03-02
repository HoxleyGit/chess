package com.company.engine.game;

public interface BadMoveObservableBoard extends Board {

    void subscribe(BadMoveObserver badMoveObserver);
}
