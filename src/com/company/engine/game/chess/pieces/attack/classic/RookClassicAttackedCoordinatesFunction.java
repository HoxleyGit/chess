package com.company.engine.game.chess.pieces.attack.classic;

import com.company.commons.move.IntegerCoordinate;
import com.company.engine.game.chess.pieces.attack.AttackedCoordinatesFunction;
import com.company.engine.game.chess.pieces.attack.AttackingPiecesBoard;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiece;

import java.util.HashSet;
import java.util.Set;

public class RookClassicAttackedCoordinatesFunction extends AttackedCoordinatesFunction {

    public RookClassicAttackedCoordinatesFunction(ClassicRuledPiece relatedPiece, AttackingPiecesBoard board) {
        super(relatedPiece, board);
    }

    @Override
    protected Set<IntegerCoordinate> getAttackedCoordinatesByRelatedPieceCoordinate(
            IntegerCoordinate relatedPieceCoordinate) {
        var relatedPieceRowIndex = relatedPieceCoordinate.getRowIndex();
        var relatedPieceColumnIndex = relatedPieceCoordinate.getColumnIndex();
        var attackedCoordinates = new HashSet<IntegerCoordinate>();
        for (var direction = 0; direction < 4; direction++) {
            var isFirstOccupiedBoardCoordinateNotFound = true;
            for (var rowIndex = relatedPieceRowIndex + getStartedRowIndexIncrementer(direction);
                 shouldRowsBeIterated(direction, rowIndex) && isFirstOccupiedBoardCoordinateNotFound;
                 rowIndex = getNextRowIndex(direction, rowIndex)) {
                for (var columnIndex = relatedPieceColumnIndex + getStartedColumnIncrementer(direction);
                     shouldColumnsBeIterated(direction, columnIndex) && isFirstOccupiedBoardCoordinateNotFound;
                     columnIndex = getNextColumnIndex(direction, columnIndex)) {
                    var attackedCoordinate = new IntegerCoordinate(rowIndex, columnIndex);
                    isFirstOccupiedBoardCoordinateNotFound =
                            !board.isCoordinateOccupied(new IntegerCoordinate(rowIndex, columnIndex));
                    attackedCoordinates.add(attackedCoordinate);
                }
            }
        }
        return attackedCoordinates;
    }

    private int getStartedRowIndexIncrementer(int direction) {
        return switch (direction) {
            case 0, 2 -> 1;
            case 1, 3 -> 0;
            default -> throw new UnsupportedOperationException();
        };
    }

    private boolean shouldRowsBeIterated(int direction, int rowIndex) {
        return switch (direction) {
            case 0 -> rowIndex < board.getRowsNumber();
            case 2 -> rowIndex >= board.getFirstRowIndex();
            case 1, 3 -> board.getCoordinateOf(relatedPiece)
                    .map(relatedPieceCoordinate -> relatedPieceCoordinate.getRowIndex() != rowIndex)
                    .orElse(false);
            default -> throw new UnsupportedOperationException();
        };
    }

    private int getNextRowIndex(int direction, int currentRowIndex) {
        return switch (direction) {
            case 0, 1 -> currentRowIndex + 1;
            case 2, 3 -> currentRowIndex - 1;
            default -> throw new UnsupportedOperationException();
        };
    }

    private int getStartedColumnIncrementer(int direction) {
        return switch (direction) {
            case 0, 2 -> 0;
            case 1, 3 -> 1;
            default -> throw new UnsupportedOperationException();
        };
    }

    private boolean shouldColumnsBeIterated(int direction, int columnIndex) {
        return switch (direction) {
            case 1 -> columnIndex >= board.getFirstColumnIndex();
            case 3 -> columnIndex < board.getLastColumnIndex();
            case 0, 2 -> board.getCoordinateOf(relatedPiece)
                    .map(relatedPieceCoordinate -> relatedPieceCoordinate.getColumnIndex() != columnIndex)
                    .orElse(false);
            default -> throw new UnsupportedOperationException();
        };
    }

    private int getNextColumnIndex(int direction, int currentColumnIndex) {
        return switch (direction) {
            case 0, 1 -> currentColumnIndex - 1;
            case 2, 3 -> currentColumnIndex + 1;
            default -> throw new UnsupportedOperationException();
        };
    }
}
