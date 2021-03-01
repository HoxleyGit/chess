package com.company.commons.board;

import com.company.commons.move.IntegerCoordinate;
import com.company.commons.move.PlaneMove;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiece;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiecesBoard;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SquareBoard<TPiece> {

    private final TPiece[][] fields;

    private final int rowsNumber;

    private final int columnsNumber;

    private final int lastRowIndex;

    private final int lastColumnIndex;

    public SquareBoard(int rowsNumber, int columnNumber) {
        this.fields = (TPiece[][]) new Object[rowsNumber][columnNumber];
        this.rowsNumber = rowsNumber;
        this.columnsNumber = columnNumber;
        this.lastRowIndex = rowsNumber - 1;
        this.lastColumnIndex = columnsNumber - 1;
    }

    public void placePiecesAtRow(Supplier<TPiece> pieceSupplier, int rowIndex) {
        for(int columnIndex = getFirstColumnIndex(); columnIndex < getColumnsNumber(); columnIndex++) {
            placePiece(pieceSupplier, new IntegerCoordinate(rowIndex, columnIndex));
        }
    }

    public void placePiecesColumnMirroring(Supplier<TPiece> pieceSupplier, IntegerCoordinate coordinate) {
        placePiece(pieceSupplier, coordinate);
        placePiece(pieceSupplier, new IntegerCoordinate(
                coordinate.getRowIndex(), lastColumnIndex - coordinate.getColumnIndex()));
    }

    public void placePiece(Supplier<TPiece> pieceSupplier, IntegerCoordinate coordinate) {
        placePiece(pieceSupplier.get(), coordinate);
    }

    public void placePiece(TPiece piece, IntegerCoordinate coordinate) {
        fields[coordinate.getRowIndex()][coordinate.getColumnIndex()] = piece;
    }

    public void move(PlaneMove move) {
        setPieceIfCoordinateIsFound(getPiece(move.getSource()).orElse(null), move.getTarget());
    }

    public Optional<IntegerCoordinate> getCoordinateOf(ClassicRuledPiece piece) {
        for (int rowIndex = getFirstRowIndex(); rowIndex < getRowsNumber(); rowIndex++) {
            for(int columnIndex = getFirstColumnIndex(); columnIndex < getColumnsNumber(); columnIndex++) {
                var currentlyTestedCoordinate = new IntegerCoordinate(rowIndex, columnIndex);
                if(getPiece(currentlyTestedCoordinate).map(piece::equals).orElse(false)){
                    return Optional.of(currentlyTestedCoordinate);
                }
            }
        }
        return Optional.empty();
    }

    public boolean isCoordinateFound(IntegerCoordinate coordinate) {
        var rowIndex = coordinate.getRowIndex();
        var columnIndex = coordinate.getColumnIndex();
        var boardFirstRowIndex = getFirstRowIndex();
        return rowIndex >= getFirstRowIndex() &&
                columnIndex >= getFirstColumnIndex() &&
                coordinate.getRowIndex() < fields.length &&
                coordinate.getColumnIndex() < fields[boardFirstRowIndex].length;
    }

    public int getRowsNumber() {
        return rowsNumber;
    }

    public int getColumnsNumber() {
        return columnsNumber;
    }

    public boolean isCoordinateOccupied(IntegerCoordinate integerCoordinate) {
        return getPiece(integerCoordinate).isPresent();
    }

    public int getFirstRowIndex() {
        return 0;
    }

    public Set<TPiece> getAllPieces() {
        return getAllBoardPiecesStream().filter(Objects::nonNull).collect(Collectors.toSet());
    }

    private Stream<TPiece> getAllBoardPiecesStream() {
        return Arrays.stream(fields).flatMap(Arrays::stream);
    }

    public SquareBoard<TPiece> copyOf() {
        var squareBoard =  new SquareBoard<TPiece>(rowsNumber, columnsNumber);
        getOccupiedCoordinates().forEach(occupiedCoordinate ->
                squareBoard.placePiece(getPiece(occupiedCoordinate).orElseThrow(), occupiedCoordinate));
        return squareBoard;
    }

    public Set<IntegerCoordinate> getCoordinatesBetweenDiagonally(PlaneMove move) {
        return move.getCoordinatesBetweenDiagonally(move).stream()
                .filter(this::isCoordinateFound)
                .collect(Collectors.toSet());
    }

    public Set<IntegerCoordinate> getCoordinatesBetweenStraight(PlaneMove move) {
        return move.getCoordinatesBetweenStraight(move).stream()
                .filter(this::isCoordinateFound)
                .collect(Collectors.toSet());
    }

    public Optional<TPiece> getFirstPieceOfRow(int rowIndex) {
        return getPieceByRowAndColumn(rowIndex, getFirstColumnIndex());
    }

    public Optional<TPiece> getLastPieceOfRow(int rowIndex) {
        return getPieceByRowAndColumn(rowIndex, getLastColumnIndex());
    }

    private Optional<TPiece> getPieceByRowAndColumn(int rowIndex, int columnIndex) {
        return getPiece(new IntegerCoordinate(rowIndex, columnIndex));
    }

    public int getLastColumnIndex() {
        return lastColumnIndex;
    }

    public int getLastRowIndex() {
        return lastRowIndex;
    }

    public int getFirstColumnIndex() {
        return 0;
    }

    public void setPieceIfCoordinateIsFound(TPiece piece, IntegerCoordinate coordinate) {
        if (isCoordinateFound(coordinate)) {
            fields[coordinate.getRowIndex()][coordinate.getColumnIndex()] = piece;
        }
    }

    public Optional<TPiece> getPiece(IntegerCoordinate coordinate) {
        return isCoordinateFound(coordinate) ?
                Optional.ofNullable(getPieceOrThrowException(coordinate)) : Optional.empty();
    }

    private TPiece getPieceOrThrowException(IntegerCoordinate coordinate) {
        return fields[coordinate.getRowIndex()][coordinate.getColumnIndex()];
    }

    public Set<IntegerCoordinate> getOccupiedCoordinates() {
        var occupiedCoordinates = new HashSet<IntegerCoordinate>();
        for (int rowIndex = getFirstRowIndex(); rowIndex < getRowsNumber(); rowIndex++) {
            for(int columnIndex = getFirstColumnIndex(); columnIndex < getColumnsNumber(); columnIndex++) {
                var currentlyTestedCoordinate = new IntegerCoordinate(rowIndex, columnIndex);
                if(getPiece(currentlyTestedCoordinate).isPresent()){
                    occupiedCoordinates.add(currentlyTestedCoordinate);
                }
            }
        }
        return occupiedCoordinates;
    }
}
