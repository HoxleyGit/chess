package com.company.ui.console;

import com.company.engine.game.BoardFactory;

import java.util.Scanner;

import static com.company.engine.game.GameType.CLASSIC_CHESS;

public class ConsoleWizzard {

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("1 - Start classic chess game");
            System.out.println("Any other key - Exit");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("Starting new classic chess game");
                    new ConsoleMovesGame(
                            new BoardFactory().createMovesGame(CLASSIC_CHESS),
                            new ClassicChessMoveMapper()).run();
                    break;
                default:
                    running = false;
                    break;
            }
        }
    }
}
