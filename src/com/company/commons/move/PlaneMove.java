package com.company.commons.move;

public class PlaneMove {

    private final IntegerCoordinate source;

    private final IntegerCoordinate target;

    public PlaneMove(IntegerCoordinate source, IntegerCoordinate target) {
        this.source = source;
        this.target = target;
    }

    public int getSourceRowIndex() {
        return source.rowIndex;
    }

    public int getSourceColumnIndex() {
        return source.columnIndex;
    }

    public IntegerCoordinate getSource() {
        return source;
    }

    public IntegerCoordinate getTarget() {
        return target;
    }

    public boolean isDiagonalMove() {
        return source.columnIndex != target.columnIndex &&
                source.rowIndex != target.rowIndex;
    }

    public boolean isOneStepMove() {
        return Math.abs(source.columnIndex - target.columnIndex) == 1 ||
                Math.abs(source.rowIndex - target.rowIndex) == 1;
    }

    public boolean isStraightMove() {
        return source.columnIndex == target.columnIndex ^
                source.rowIndex == target.rowIndex;
    }

    public boolean isNStepForwardStraightMove(int nStep) {
        return source.rowIndex - target.rowIndex == nStep &&
                source.columnIndex == target.columnIndex;
    }

    public boolean isNStepBackwardStraightMove(int nStep) {
        return target.rowIndex - source.rowIndex == nStep &&
                source.columnIndex == target.columnIndex;
    }

    public boolean isNStepLeftStraightMove(int nStep) {
        throw new UnsupportedOperationException();
    }

    public boolean isNStepRightStraightMove(int nStep) {
        throw new UnsupportedOperationException();
    }

    public boolean isShortestLMove() {
        return (source.columnIndex - target.columnIndex == 1 ||
                source.rowIndex - target.rowIndex == 1) &&
                (source.columnIndex - target.columnIndex == 2 ^
                source.rowIndex - target.rowIndex == 2);
    }

    public boolean isNStepForwardDiagonalMove(int nStep) {
        return source.rowIndex - target.rowIndex == nStep &&
                Math.abs(source.columnIndex - target.columnIndex) == nStep;
    }

    public boolean isNStepBackwardDiagonalMove(int nStep) {
        return target.rowIndex - source.rowIndex == nStep &&
                Math.abs(source.columnIndex - target.columnIndex) == nStep;
    }
}
