package com.company.ui.console;

import com.company.engine.game.BadMoveObserver;
import com.company.engine.game.BadMoveObservableBoard;
import com.company.commons.move.PlaneMove;
import com.company.engine.game.MoveMadeObservable;
import com.company.engine.game.MoveMadeObserver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Collectors;

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
        System.out.println("Press: ");
        System.out.println("1 - Start new chess game");
        System.out.println("2 - Read initial moves");
        var scanner = new Scanner(System.in);
        var choice = scanner.nextInt();
        switch (choice) {
            case 1: runChessGame();
            break;
            case 2: readInitialMoves();runChessGame();
            break;
        }
        }

    private void readInitialMoves() {
        while(true) {
            System.out.println("Type initial moves file path: ");
            var scanner = new Scanner(System.in);
            var filePath = scanner.nextLine();
            try {
                Files.lines(Paths.get(filePath)).map(mapper::map).collect(Collectors.toList()).forEach(board::move);
                break;
            } catch (IOException e) {
                System.out.println("File not found, try again");
            } catch (Exception e) {
                System.out.println("Cannot translate file moves, try again");
            }
        }
    }

    private void runChessGame() {
        System.out.println(board.toString());
        while(true) {
            System.out.println("Make move (e.g. E2->E4 means - place piece from E2 to E4): ");
            var scanner = new Scanner(System.in);
            var nextMove = scanner.nextLine();
            PlaneMove mappedMove = null;
            try {
                mappedMove = mapper.map(nextMove);
            } catch (Exception e) {
                System.out.println("Bad move format");
                continue;
            }
            board.move(mappedMove);
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
