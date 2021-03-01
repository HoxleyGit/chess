package com.company.engine.game;

public interface ObservableBoard extends Board {

    void subscribe(BadMoveObserver badMoveObserver);
}
