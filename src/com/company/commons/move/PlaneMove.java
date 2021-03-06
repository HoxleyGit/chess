package com.company.commons.move;

import java.util.HashSet;
import java.util.Objects;
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
                source.rowIndex != target.rowIndex &&
                Math.abs(getSourceRowIndex() - getTargetRowIndex()) ==
                Math.abs(getSourceColumnIndex() - getTargetColumnIndex());
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
        return getSourceRowIndex() == getTargetRowIndex() &&
                getSourceColumnIndex() - getTargetColumnIndex() == nStep;
    }

    public boolean isNStepRightStraightMove(int nStep) {
        return getSourceRowIndex() == getTargetRowIndex() &&
                getTargetColumnIndex() - getSourceColumnIndex() == nStep;
    }

    public boolean isShortestLMove() {
        return (Math.abs(source.columnIndex - target.columnIndex) == 1 ||
                Math.abs(source.rowIndex - target.rowIndex) == 1) &&
                (Math.abs(source.columnIndex - target.columnIndex) == 2 ^
                        Math.abs(source.rowIndex - target.rowIndex) == 2);
    }

    public boolean isNStepForwardDiagonalMove(int nStep) {
        return source.rowIndex - target.rowIndex == nStep &&
                Math.abs(source.columnIndex - target.columnIndex) == nStep;
    }

    public boolean isNStepBackwardDiagonalMove(int nStep) {
        return target.rowIndex - source.rowIndex == nStep &&
                Math.abs(source.columnIndex - target.columnIndex) == nStep;
    }

    public Set<IntegerCoordinate> getCoordinatesBetweenDiagonally() {
        if (!isDiagonalMove()) {
            return new HashSet<>();
        }

        var moveSourceRowIndex = getSourceRowIndex();
        var moveSourceColumnIndex = getSourceColumnIndex();
        var moveTargetRowIndex = getTargetRowIndex();
        var moveTargetColumnIndex = getTargetColumnIndex();
        var minimalRowIndex = Math.min(moveSourceRowIndex, moveTargetRowIndex);
        var maximalRowIndex = Math.max(moveSourceRowIndex, moveTargetRowIndex);
        var minimalColumnIndex = Math.min(moveSourceColumnIndex, moveTargetColumnIndex);
        var maximalColumnIndex = Math.max(moveSourceColumnIndex, moveTargetColumnIndex);
        var minimalCoordinate = new IntegerCoordinate(minimalRowIndex, minimalColumnIndex);
        var times = maximalColumnIndex - minimalColumnIndex - 1;
        var coordinatesBetweenDiagonally = new HashSet<IntegerCoordinate>();
        int rowStartIndex =
                minimalCoordinate.equals(getSource()) || minimalCoordinate.equals(getTarget()) ?
                        minimalRowIndex : maximalRowIndex;
        int rowIncrementer =
                minimalCoordinate.equals(getSource()) || minimalCoordinate.equals(getTarget()) ? 1 : -1;
        for (int time = 1; time <= times; time++) {
            coordinatesBetweenDiagonally.add(new IntegerCoordinate(
                    rowStartIndex + (rowIncrementer * time), minimalColumnIndex + time));
        }
        return coordinatesBetweenDiagonally;
    }

    public Set<IntegerCoordinate> getCoordinatesBetweenStraight() {
        if (!isStraightMove()) {
            return new HashSet<>();
        }

        var moveSourceRowIndex = getSourceRowIndex();
        var moveTargetRowIndex = getTargetRowIndex();
        var moveSourceColumnIndex = getSourceColumnIndex();
        var moveTargetColumnIndex = getTargetColumnIndex();
        var minimalRowIndex = Math.min(moveSourceRowIndex, moveTargetRowIndex);
        var maximalRowIndex = Math.max(moveSourceRowIndex, moveTargetRowIndex);
        var minimalColumnIndex = Math.min(moveSourceColumnIndex, moveTargetColumnIndex);
        var maximalColumnIndex = Math.max(moveSourceColumnIndex, moveTargetColumnIndex);
        var times = (minimalRowIndex != maximalRowIndex ?
                maximalRowIndex - minimalRowIndex :
                maximalColumnIndex - minimalColumnIndex) - 1;
        var coordinatesBetweenStraight = new HashSet<IntegerCoordinate>();
        for (int time = 1; time <= times; time++) {
            coordinatesBetweenStraight.add(new IntegerCoordinate(
                    minimalRowIndex + ((minimalRowIndex == maximalRowIndex ? 0 : 1) * time),
                    minimalColumnIndex + ((minimalColumnIndex == maximalColumnIndex ? 0 : 1) * time)));
        }
        return coordinatesBetweenStraight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaneMove planeMove = (PlaneMove) o;
        return Objects.equals(source, planeMove.source) &&
                Objects.equals(target, planeMove.target);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, target);
    }
}
