package com.company.commons.move;

import java.util.HashSet;
import java.util.Set;

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

    public int getTargetRowIndex() {
        return target.getRowIndex();
    }

    public int getTargetColumnIndex() {
        return target.getColumnIndex();
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

    public Set<IntegerCoordinate> getCoordinatesBetweenDiagonally(PlaneMove move) {
        if(!move.isDiagonalMove()) {
            return new HashSet<>();
        }

        var moveSourceRowIndex = move.getSourceRowIndex();
        var moveSourceColumnIndex = move.getSourceColumnIndex();
        var moveTargetRowIndex = move.getTargetRowIndex();
        var moveTargetColumnIndex = move.getTargetColumnIndex();
        var minimalRowIndex = Math.min(moveSourceRowIndex, moveTargetRowIndex);
        var maximalRowIndex = Math.max(moveSourceRowIndex, moveTargetRowIndex);
        var minimalColumnIndex = Math.min(moveSourceColumnIndex, moveTargetColumnIndex);
        var maximalColumnIndex = Math.max(moveSourceColumnIndex, moveTargetColumnIndex);
        var minimalCoordinate = new IntegerCoordinate(minimalRowIndex, minimalColumnIndex);
        int rowsIncrementer =
                minimalCoordinate.equals(move.getSource()) || minimalCoordinate.equals(move.getTarget()) ? 1 : -1;
        var coordinatesBetweenDiagonally = new HashSet<IntegerCoordinate>();
        for(int rowIndex = minimalRowIndex; rowIndex <= maximalRowIndex; rowIndex = rowIndex + rowsIncrementer) {
            for(int columnIndex = minimalColumnIndex; columnIndex <= maximalColumnIndex; columnIndex++) {
                coordinatesBetweenDiagonally.add(new IntegerCoordinate(rowIndex, columnIndex));
            }
        }
        return coordinatesBetweenDiagonally;
    }

    public Set<IntegerCoordinate> getCoordinatesBetweenStraight(PlaneMove move) {
        if(!move.isStraightMove()) {
            return new HashSet<>();
        }

        var moveSourceRowIndex = move.getSourceRowIndex();
        var moveTargetRowIndex = move.getTargetRowIndex();
        var moveSourceColumnIndex = move.getSourceColumnIndex();
        var moveTargetColumnIndex = move.getTargetColumnIndex();
        var minimalRowIndex = Math.min(moveSourceRowIndex, moveTargetRowIndex);
        var maximalRowIndex = Math.max(moveSourceRowIndex, moveTargetRowIndex);
        var minimalColumnIndex = Math.min(moveSourceColumnIndex, moveTargetColumnIndex);
        var maximalColumnIndex = Math.max(moveSourceColumnIndex, moveTargetColumnIndex);
        var times = (minimalRowIndex == maximalRowIndex ?
                maximalRowIndex - minimalRowIndex :
                maximalColumnIndex - minimalColumnIndex) - 1;
        var coordinatesBetweenStraight = new HashSet<IntegerCoordinate>();
        for(int time = 0; time < times; time++) {
            coordinatesBetweenStraight.add(new IntegerCoordinate(
                    minimalRowIndex + (minimalRowIndex == maximalRowIndex ? 0 : 1),
                    minimalColumnIndex + (minimalColumnIndex == maximalColumnIndex ? 0 : 1)));
        }
        return coordinatesBetweenStraight;
    }
}
