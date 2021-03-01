package com.company.ui.console;

import com.company.commons.move.IntegerCoordinate;
import com.company.commons.move.PlaneMove;

public class ClassicChessMoveMapper implements StringToMoveMapper {

    public PlaneMove map(String move) {
        String[] stringCoordinates = move.split("->");
        return new PlaneMove(
                mapStringCoordinateToChessboardCoordinate(stringCoordinates[0]),
                mapStringCoordinateToChessboardCoordinate(stringCoordinates[1]));
    }

    private IntegerCoordinate mapStringCoordinateToChessboardCoordinate(String stringCoordinate) {
        return new IntegerCoordinate(
                mapRowStringToIntegerPointRow("" + stringCoordinate.charAt(1)),
                mapColumnStringToIntegerPointColumn("" + stringCoordinate.charAt(0)));
    }

    private int mapColumnStringToIntegerPointColumn(String columnString) {
        return switch (columnString) {
            case "A" -> 0;
            case "B" -> 1;
            case "C" -> 2;
            case "D" -> 3;
            case "E" -> 4;
            case "F" -> 5;
            case "G" -> 6;
            case "H" -> 7;
            default -> throw new UnsupportedOperationException();
        };
    }

    private int mapRowStringToIntegerPointRow(String rowString) {
        return 8 - Integer.parseInt(rowString);
    }
}
