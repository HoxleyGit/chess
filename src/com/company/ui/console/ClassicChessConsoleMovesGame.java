package com.company.ui.console;

import com.company.commons.history.MovesHistory;
import com.company.engine.game.BadMoveObserver;
import com.company.engine.game.BadMoveObservableBoard;
import com.company.commons.move.PlaneMove;
import com.company.engine.game.MoveMadeObservable;
import com.company.engine.game.MoveMadeObserver;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiece;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ClassicChessConsoleMovesGame implements BadMoveObserver, MoveMadeObserver, ConsoleMovesGame {

    private final BadMoveObservableBoard board;

    private final MovesHistory<ClassicRuledPiece> movesHistory;

    private final ClassicChessMoveMapper mapper;

    public ClassicChessConsoleMovesGame(BadMoveObservableBoard board,
                                        MoveMadeObservable moveMadeObservable,
                                        MovesHistory<ClassicRuledPiece> movesHistory,
                                        ClassicChessMoveMapper mapper) {
        this.board = board;
        board.subscribe(this);
        moveMadeObservable.subscribe(this);
        this.movesHistory = movesHistory;
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
            case 1:
                runChessGame();
                break;
            case 2:
                readInitialMoves();
                runChessGame();
                break;
        }
    }

    private void readInitialMoves() {
        var notFinished = true;
        while (notFinished) {
            System.out.println("Type initial moves file path (e.g. C:\\Users\\Some Windows User\\Desktop\\initial_openings\\italian_game.txt): ");
            var scanner = new Scanner(System.in);
            var filePath = scanner.nextLine();
            notFinished = !readInitialFile(filePath);
        }
    }

    private boolean readInitialFile(String path) {
        try {
            Files.lines(Paths.get(path)).map(mapper::map).collect(Collectors.toList()).forEach(board::move);
            return true;
        } catch (IOException e) {
            System.out.println("File not found, try again");
            return false;
        } catch (Exception e) {
            System.out.println("Cannot translate file moves, try again");
            return false;
        }
    }

    private void runChessGame() {
        System.out.println(board.toString());
        while (true) {
            System.out.printf("It is " + (movesHistory.countMoves() % 2 == 0 ? "WHITES' move" : "BLACKS' move"));
            System.out.println(", make move (e.g. E2->E4 means - place piece from E2 to E4): ");
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
        System.out.println(violation + ", try again.");
    }

    @Override
    public void onMoveMade() {
        System.out.println(board.toString());
    }
}
