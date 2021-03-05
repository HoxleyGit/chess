package com.company.engine.game.chess.pieces.attack.classic;

import com.company.commons.move.IntegerCoordinate;
import com.company.engine.game.chess.pieces.attack.AttackedCoordinatesFunction;
import com.company.engine.game.chess.pieces.attack.AttackingPiecesBoard;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiece;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiecesBoard;

import java.util.HashSet;
import java.util.Set;

public class RookClassicAttackedCoordinatesFunction extends AttackedCoordinatesFunction {

    public RookClassicAttackedCoordinatesFunction(ClassicRuledPiece relatedPiece) {
        super(relatedPiece);
    }

    @Override
    protected Set<IntegerCoordinate> getAttackedCoordinatesByRelatedPieceCoordinate(
            IntegerCoordinate relatedPieceCoordinate, ClassicRuledPiecesBoard board) {
        var relatedPieceRowIndex = relatedPieceCoordinate.getRowIndex();
        var relatedPieceColumnIndex = relatedPieceCoordinate.getColumnIndex();
        var attackedCoordinates = new HashSet<IntegerCoordinate>();
        for (var direction = 0; direction < 4; direction++) {
            var isFirstOccupiedBoardCoordinateNotFound = true;
            var rowIndex = relatedPieceRowIndex;
            var columnIndex = relatedPieceColumnIndex;
            while((shouldRowsBeIterated(direction, rowIndex, board) ||
                    shouldColumnsBeIterated(direction, columnIndex, board)) &&
                    isFirstOccupiedBoardCoordinateNotFound) {
                rowIndex = rowIndex + getStartedRowIndexIncrementer(direction);
                columnIndex = columnIndex + getStartedColumnIncrementer(direction);
                var attackedCoordinate = new IntegerCoordinate(rowIndex, columnIndex);
                isFirstOccupiedBoardCoordinateNotFound =
                        !board.isCoordinateOccupied(new IntegerCoordinate(rowIndex, columnIndex));
                attackedCoordinates.add(attackedCoordinate);
            }
        }
        return attackedCoordinates;
    }

    private int getStartedRowIndexIncrementer(int direction) {
        return switch (direction) {
            case 0 -> 1;
            case 2 -> -1;
            case 1, 3 -> 0;
            default -> throw new UnsupportedOperationException();
        };
    }

    private boolean shouldRowsBeIterated(int direction, int rowIndex, ClassicRuledPiecesBoard board) {
        return switch (direction) {
            case 0 -> rowIndex < board.getRowsNumber() - 1;
            case 2 -> rowIndex > board.getFirstRowIndex();
            case 1, 3 -> false;
            default -> throw new UnsupportedOperationException();
        };
    }

    private int getStartedColumnIncrementer(int direction) {
        return switch (direction) {
            case 0, 2 -> 0;
            case 1 -> - 1;
            case 3 -> 1;
            default -> throw new UnsupportedOperationException();
        };
    }

    private boolean shouldColumnsBeIterated(int direction, int columnIndex, ClassicRuledPiecesBoard board) {
        return switch (direction) {
            case 1 -> columnIndex > board.getFirstColumnIndex();
            case 3 -> columnIndex < board.getColumnsNumber() - 1;
            case 0, 2 -> false;
            default -> throw new UnsupportedOperationException();
        };
    }
}
