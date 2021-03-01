package com.company.engine.game.chess.chessboard;

import java.util.Optional;

public class ChessboardCoordinate {

    private final ChessboardColumn chessboardColumn;

    private final ChessboardRow chessboardRow;

    public static Optional<ChessboardCoordinate> of(int columnIndex, int rowIndex) {
        var column = ChessboardColumn.fromIndex(columnIndex);
        var row = ChessboardRow.fromIndex(rowIndex);
        if(column.isEmpty() || row.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(new ChessboardCoordinate(column.get(), row.get()));
    }

    public ChessboardCoordinate(ChessboardColumn chessboardColumn, ChessboardRow chessboardRow) {
        this.chessboardColumn = chessboardColumn;
        this.chessboardRow = chessboardRow;
    }

    public ChessboardColumn getChessboardColumn() {
        return chessboardColumn;
    }

    public ChessboardRow getChessboardRow() {
        return chessboardRow;
    }

    public int getChessboardColumnAsArrayIndex() {
        return chessboardColumn.asArrayIndex();
    }

    public int getChessboardColumnMirrorAsArrayIndex() {
        return chessboardColumn.mirrorColumnAsArrayIndex();
    }

    public int getChessboardRowAsArrayIndex() {
        return chessboardRow.asArrayIndex();
    }

    public int getChessboardRowMirrorAsArrayIndex() {
        return chessboardRow.mirrorRowAsArrayIndex();
    }

    public ChessboardCoordinate mirrorByColumn() {
        return new ChessboardCoordinate(chessboardColumn.mirrorColumn(), chessboardRow);
    }

    public ChessboardCoordinate mirrorByRow() {
        return new ChessboardCoordinate(chessboardColumn, chessboardRow.mirrorRow());
    }

    public ChessboardCoordinate mirrorByRowAndColumn() {
        return new ChessboardCoordinate(chessboardColumn.mirrorColumn(), chessboardRow.mirrorRow());
    }

    public ChessboardCoordinate getNextNStepForwardStraightCoordinate(int nStep) {
        return new ChessboardCoordinate(chessboardColumn.asArrayIndex(), chessboardRow.asArrayIndex() - nStep);
    }

    public ChessboardCoordinate getNextNStepBackwardStraightCoordinate(int nStep) {
        return new ChessboardCoordinate(chessboardColumn.asArrayIndex(), chessboardRow.asArrayIndex() + nStep);
    }

    public ChessboardCoordinate getNextNStepLeftStraightCoordinate(int nStep) {
        return new ChessboardCoordinate(chessboardColumn.asArrayIndex() - nStep, chessboardRow.asArrayIndex());
    }

    public ChessboardCoordinate getNextNStepRightStraightCoordinate(int nStep) {
        return new ChessboardCoordinate(chessboardColumn.asArrayIndex() + nStep, chessboardRow.asArrayIndex());
    }
}
