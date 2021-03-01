package com.company.engine.game;

import com.company.commons.move.PlaneMove;

import java.util.List;

public class ValidatedBoard implements ObservableBoard {

    private final Board board;

    private final MoveValidator moveValidator;

    private final List<BadMoveObserver> badMoveObservers;

    public ValidatedBoard(Board board, MoveValidator moveValidator, List<BadMoveObserver> badMoveObservers) {
        this.board = board;
        this.moveValidator = moveValidator;
        this.badMoveObservers = badMoveObservers;
    }

    @Override
    public void move(PlaneMove move) {
        if(moveValidator.isValid(move)){
            board.move(move);
        } else {
            badMoveObservers.forEach(observer -> observer.onBadMove(move, "Move is illegal."));
        }
    }

    @Override
    public void subscribe(BadMoveObserver badMoveObserver) {
        badMoveObservers.add(badMoveObserver);
    }
}
