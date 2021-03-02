package com.company.ui.console;

public class ConsoleWizzard {

    public void run() {
       new ConsoleMovesGameFactory().createConsoleMovesGame(ConsoleMovesGameType.CLASSIC_CHESS).run();
    }
}
