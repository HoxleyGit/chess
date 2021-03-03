package com.company.engine.game.chess.rule.classic;

import com.company.commons.history.GameStateBoard;
import com.company.commons.move.IntegerCoordinate;
import com.company.commons.move.PlaneMove;
import com.company.engine.game.validation.rule.basic.BasicRuledPiecesBoard;

import java.util.Optional;
import java.util.Set;

public interface ClassicRuledPiecesBoard extends BasicRuledPiecesBoard<ClassicRuledPiece> {

    Set<ClassicRuledPiece> getAllPieces();

    ClassicRuledPiecesBoard copyOf();

    Set<IntegerCoordinate> getCoordinatesBetweenDiagonally(PlaneMove move);

    Set<IntegerCoordinate> getCoordinatesBetweenStraight(PlaneMove move);

    Optional<ClassicRuledPiece> getFirstPieceOfRow(int rowIndex);

    Optional<ClassicRuledPiece> getLastPieceOfRow(int rowIndex);

    int getLastColumnIndex();

    int getFirstColumnIndex();

    int getLastRowIndex();

    int getFirstRowIndex();

    void placePiece(ClassicRuledPiece piece, IntegerCoordinate coordinate);

    boolean isCoordinateFound(IntegerCoordinate coordinate);

    Optional<IntegerCoordinate> getCoordinateOf(ClassicRuledPiece piece);

    boolean isCoordinateOccupied(IntegerCoordinate integerCoordinate);

    int getRowsNumber();

    int getColumnsNumber();
}
