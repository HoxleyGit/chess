package com.company.ui.console;

import com.company.engine.game.BadMoveObserver;
import com.company.engine.game.Board;
import com.company.engine.game.ObservableBoard;
import com.company.engine.game.ValidatedBoard;
import com.company.commons.move.PlaneMove;

import java.util.Scanner;

public class ConsoleMovesGame implements BadMoveObserver {

    private final ObservableBoard board;

    private final ClassicChessMoveMapper mapper;

    public ConsoleMovesGame(ObservableBoard board, ClassicChessMoveMapper mapper) {
        this.board = board;
        board.subscribe(this);
        this.mapper = mapper;
    }

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
}
