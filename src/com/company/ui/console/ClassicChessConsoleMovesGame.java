package com.company.ui.console;

import com.company.engine.game.BadMoveObserver;
import com.company.engine.game.BadMoveObservableBoard;
import com.company.commons.move.PlaneMove;
import com.company.engine.game.MoveMadeObservable;
import com.company.engine.game.MoveMadeObserver;

import java.util.Scanner;

public class ClassicChessConsoleMovesGame implements BadMoveObserver, MoveMadeObserver, ConsoleMovesGame {

    private final BadMoveObservableBoard board;

    private final ClassicChessMoveMapper mapper;

    public ClassicChessConsoleMovesGame(BadMoveObservableBoard board,
                                        MoveMadeObservable moveMadeObservable,
                                        ClassicChessMoveMapper mapper) {
        this.board = board;
        board.subscribe(this);
        moveMadeObservable.subscribe(this);
        this.mapper = mapper;
    }

    @Override
    public void run() {
        while(true) {
            System.out.println("Make move: ");
            var scanner = new Scanner(System.in);
            var nextMove = scanner.next();
            board.move(mapper.map(nextMove));
        }
    }

    @Override
    public void onBadMove(PlaneMove move, String violation) {
        System.out.println(violation);
    }

    @Override
    public void onMoveMade() {
        System.out.println(board.toString());
    }
}
