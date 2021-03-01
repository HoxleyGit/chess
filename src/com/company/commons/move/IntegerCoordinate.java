package com.company.commons.move;

import com.company.engine.game.chess.chessboard.ChessboardCoordinate;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntegerCoordinate {

    int rowIndex;

    int columnIndex;

    public IntegerCoordinate(int rowIndex, int columnIndex) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public Set<IntegerCoordinate> getAllAdjacentCoordinates() {
        return Stream.of(
                new IntegerCoordinate(rowIndex + 1, columnIndex + 1),
                new IntegerCoordinate(rowIndex + 1, columnIndex - 1),
                new IntegerCoordinate(rowIndex - 1, columnIndex + 1),
                new IntegerCoordinate(rowIndex - 1, columnIndex - 1),
                new IntegerCoordinate(rowIndex, columnIndex + 1),
                new IntegerCoordinate(rowIndex, columnIndex - 1),
                new IntegerCoordinate(rowIndex - 1, columnIndex),
                new IntegerCoordinate(rowIndex - 1, columnIndex))
                .collect(Collectors.toSet());
    }
}
