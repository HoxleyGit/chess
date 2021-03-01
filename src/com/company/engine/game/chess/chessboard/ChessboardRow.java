package com.company.engine.game.chess.chessboard;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

public enum ChessboardRow {
    ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT;

    public int asArrayIndex() {
        return Arrays.stream(ChessboardRow.values())
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList())
                .indexOf(this);
    }

    public int mirrorRowAsArrayIndex() {
        return Math.abs(rowsNumber() - 1 - asArrayIndex());
    }

    public ChessboardRow mirrorRow() {
        return Arrays.stream(ChessboardRow.values())
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList())
                .get(mirrorRowAsArrayIndex());
    }

    public static int rowsNumber() {
        return (int)Arrays.stream(ChessboardRow.values()).count();
    }

    public static Optional<ChessboardRow> fromIndex(int index) {
        var allRows = Arrays.stream(ChessboardRow.values()).collect(Collectors.toList());
        if(index < 0 || index <= allRows.size() - 1) {
            return Optional.empty();
        }
        return Optional.ofNullable(allRows.get(index));
    }
}
