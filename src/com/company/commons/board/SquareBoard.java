package com.company.commons.board;

import com.company.commons.move.IntegerCoordinate;
import com.company.commons.move.PlaneMove;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiece;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiecesBoard;

import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;

public class SquareBoard<TPiece>  {

    private final TPiece[][] fields;

    public SquareBoard(int rowsNumber, int columnNumber) {
        this.fields = (TPiece[][]) new Object[rowsNumber][columnNumber];
    }

    public void placePiecesAtRow(Supplier<TPiece> pieceSupplier, int rowIndex) {
        throw new UnsupportedOperationException();
    }

    private void placePiecesColumnMirroring(Supplier<TPiece> pieceSupplier, IntegerCoordinate coordinate) {
        throw new UnsupportedOperationException();
    }

    private void placePiece(TPiece piece, IntegerCoordinate coordinate) {
        fields[coordinate.getRowIndex()][coordinate.getColumnIndex()] = piece;
    }

    public Optional<TPiece> getAllPieces() {
        return Optional.empty();
    }

    public SquareBoard copyOf() {
        return null;
    }

    public Set<IntegerCoordinate> getCoordinatesBetweenDiagonally(PlaneMove move) {
        return null;
    }

    public Set<IntegerCoordinate> getAllChessCoordinatesBetweenStraight(PlaneMove move) {
        return null;
    }

    public Optional<TPiece> getFirstPieceOfRow(int rowIndex) {
        return Optional.empty();
    }

    public Optional<TPiece> getLastPieceOfRow(int rowIndex) {
        return Optional.empty();
    }

    public int getLastColumnIndex() {
        return 0;
    }

    public int getFirstColumnIndex() {
        return 0;
    }

    public Optional<SquareBoard> getPiece(IntegerCoordinate coordinate) {
        return Optional.empty();
    }

    public Set<IntegerCoordinate> getOccupiedCoordinates() {
        return null;
    }

    public void move(PlaneMove move) {

    }
}
