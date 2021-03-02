package com.company.engine.game;

import com.company.commons.move.PlaneMove;

import java.util.List;

public class MoveMadeObservableBoard implements MoveMadeObservable, Board {

    private final Board board;

    private final List<MoveMadeObserver> moveMadeObservers;

    public MoveMadeObservableBoard(Board board, List<MoveMadeObserver> moveMadeObservers) {
        this.board = board;
        this.moveMadeObservers = moveMadeObservers;
    }

    @Override
    public void subscribe(MoveMadeObserver moveMadeObserver) {
        moveMadeObservers.add(moveMadeObserver);
    }

    @Override
    public void move(PlaneMove move) {
        board.move(move);
        moveMadeObservers.forEach(MoveMadeObserver::onMoveMade);
    }

    @Override
    public String toString() {
        return board.toString();
    }
}
