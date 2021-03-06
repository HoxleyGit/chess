package com.company.engine.game;

import com.company.commons.move.PlaneMove;
import com.company.engine.game.validation.MoveValidator;

import java.util.List;

public class ValidatedBoardBadMove implements BadMoveObservableBoard {

    private final Board board;

    private final MoveValidator moveValidator;

    private final List<BadMoveObserver> badMoveObservers;

    public ValidatedBoardBadMove(Board board, MoveValidator moveValidator, List<BadMoveObserver> badMoveObservers) {
        this.board = board;
        this.moveValidator = moveValidator;
        this.badMoveObservers = badMoveObservers;
    }

    @Override
    public void move(PlaneMove move) {
        if(moveValidator.isValid(move)){
            board.move(move);
        } else {
            badMoveObservers.forEach(observer -> observer.onBadMove(move, "Move is illegal"));
        }
    }

    @Override
    public void subscribe(BadMoveObserver badMoveObserver) {
        badMoveObservers.add(badMoveObserver);
    }

    @Override
    public String toString() {
        return board.toString();
    }
}
