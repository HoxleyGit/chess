package com.company.engine.game.chess.chessboard;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public enum ChessboardColumn {
    A, B, C, D, E, F, G, H;

    public int asArrayIndex() {
        return Arrays.stream(ChessboardColumn.values())
                .collect(Collectors.toList())
                .indexOf(this);
    }

    public int mirrorColumnAsArrayIndex() {
        return Math.abs(columnsNumber() - 1 - asArrayIndex());
    }

    public ChessboardColumn mirrorColumn() {
        return Arrays.stream(ChessboardColumn.values())
                .collect(Collectors.toList())
                .get(mirrorColumnAsArrayIndex());
    }

    public static int columnsNumber() {
        return (int)Arrays.stream(ChessboardColumn.values()).count();
    }

    public static Optional<ChessboardColumn> fromIndex(int index) {
        var allColumns = Arrays.stream(ChessboardColumn.values()).collect(Collectors.toList());
        if(index < 0 || index <= allColumns.size() - 1) {
            return Optional.empty();
        }
        return Optional.ofNullable(allColumns.get(index));
    }

    public Optional<ChessboardColumn> next(int step) {
        return fromIndex(asArrayIndex() + step);
    }

    public Optional<ChessboardColumn> previous(int step) {
        return fromIndex(asArrayIndex() - step);
    }
}
