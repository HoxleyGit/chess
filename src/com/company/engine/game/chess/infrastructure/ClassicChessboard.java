package com.company.engine.game.chess.infrastructure;

import com.company.commons.board.SquareBoard;
import com.company.commons.history.GameStateBoard;
import com.company.commons.move.IntegerCoordinate;
import com.company.commons.move.PlaneMove;
import com.company.engine.game.chess.pieces.attack.AttackingPiecesBoard;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiece;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiecesBoard;
import com.company.engine.game.history.PiecedBoard;

import java.util.Optional;
import java.util.Set;

public class ClassicChessboard implements
        AttackingPiecesBoard, GameStateBoard<ClassicRuledPiece>, PiecedBoard<ClassicRuledPiece> {

    private final SquareBoard<ClassicRuledPiece> squareBoard;

    public ClassicChessboard(SquareBoard<ClassicRuledPiece> squareBoard) {
        this.squareBoard = squareBoard;
    }

    @Override
    public void move(PlaneMove move) {
        squareBoard.move(move);
    }

    @Override
    public Optional<IntegerCoordinate> getCoordinateOf(ClassicRuledPiece piece) {
        return squareBoard.getCoordinateOf(piece);
    }

    @Override
    public boolean isCoordinateFound(IntegerCoordinate coordinate) {
        return squareBoard.isCoordinateFound(coordinate);
    }

    @Override
    public int getRowsNumber() {
        return squareBoard.getRowsNumber();
    }

    @Override
    public int getColumnsNumber() {
        return squareBoard.getColumnsNumber();
    }

    @Override
    public boolean isCoordinateOccupied(IntegerCoordinate integerCoordinate) {
        return squareBoard.isCoordinateOccupied(integerCoordinate);
    }

    @Override
    public int getFirstRowIndex() {
        return squareBoard.getFirstRowIndex();
    }

    @Override
    public Set<ClassicRuledPiece> getAllPieces() {
        return squareBoard.getAllPieces();
    }

    @Override
    public ClassicRuledPiecesBoard copyOf() {
        return new ClassicChessboard(squareBoard.copyOf());
    }

    @Override
    public Set<IntegerCoordinate> getCoordinatesBetweenDiagonally(PlaneMove move) {
        return squareBoard.getCoordinatesBetweenDiagonally(move);
    }

    @Override
    public Set<IntegerCoordinate> getCoordinatesBetweenStraight(PlaneMove move) {
        return squareBoard.getCoordinatesBetweenStraight(move);
    }

    @Override
    public Optional<ClassicRuledPiece> getFirstPieceOfRow(int rowIndex) {
        return squareBoard.getFirstPieceOfRow(rowIndex);
    }

    @Override
    public Optional<ClassicRuledPiece> getLastPieceOfRow(int rowIndex) {
        return squareBoard.getLastPieceOfRow(rowIndex);
    }

    @Override
    public int getLastColumnIndex() {
        return squareBoard.getLastColumnIndex();
    }

    @Override
    public int getFirstColumnIndex() {
        return squareBoard.getFirstColumnIndex();
    }

    @Override
    public Optional<ClassicRuledPiece> getPiece(IntegerCoordinate coordinate) {
        return squareBoard.getPiece(coordinate);
    }

    @Override
    public Set<IntegerCoordinate> getOccupiedCoordinates() {
        return squareBoard.getOccupiedCoordinates();
    }

    @Override
    public String toString() {
        return squareBoard.toString();
    }
}
