package com.company.engine.game.chess.chessboard;

import com.company.commons.board.SquareBoard;
import com.company.commons.history.GameStateBoard;
import com.company.commons.move.IntegerCoordinate;
import com.company.commons.move.PlaneMove;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiece;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiecesBoard;
import com.company.engine.game.history.PiecedBoard;

import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;

public class ClassicChessboard implements
        ClassicRuledPiecesBoard, GameStateBoard<ClassicRuledPiece>, PiecedBoard<ClassicRuledPiece> {

    private final SquareBoard<ClassicRuledPiece> squareBoard = new SquareBoard<>(8, 8);

    public void placePiecesAtRow(Supplier<ClassicRuledPiece> pieceSupplier, int rowIndex) {
        throw new UnsupportedOperationException();
    }

    public void placePiecesColumnMirroring(Supplier<ClassicRuledPiece> pieceSupplier, IntegerCoordinate coordinate) {
        throw new UnsupportedOperationException();
    }

    public void placePiece(ClassicRuledPiece piece, IntegerCoordinate coordinate) {
        fields[coordinate.getRowIndex()][coordinate.getColumnIndex()] = piece;
    }

    @Override
    public Optional<ClassicRuledPiece> getAllPieces() {
        return squareBoard.getAllPieces();
    }

    @Override
    public ClassicRuledPiecesBoard copyOf() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<IntegerCoordinate> getCoordinatesBetweenDiagonally(PlaneMove move) {
        return null;
    }

    @Override
    public Set<IntegerCoordinate> getAllChessCoordinatesBetweenStraight(PlaneMove move) {
        return null;
    }

    @Override
    public Optional<ClassicRuledPiece> getFirstPieceOfRow(int rowIndex) {
        return Optional.empty();
    }

    @Override
    public Optional<ClassicRuledPiece> getLastPieceOfRow(int rowIndex) {
        return Optional.empty();
    }

    @Override
    public int getLastColumnIndex() {
        return 0;
    }

    @Override
    public int getFirstColumnIndex() {
        return 0;
    }

    @Override
    public void move(PlaneMove move) {

    }

    @Override
    public Optional<ClassicRuledPiece> getPiece(IntegerCoordinate coordinate) {
        return Optional.empty();
    }

    @Override
    public Set<IntegerCoordinate> getOccupiedCoordinates() {
        return null;
    }

//    public ClassicChessboard() {
//        GameState gameState = new GameState(this, new MovesHistory());
//        placePiecesAtRow(() -> new Pawn(true, this, gameState), TWO);
//        placePiecesAtRow(() -> new Pawn(false, this, gameState), SEVEN);
//        placePiecesColumnMirroring(() -> new Rook(true, this, gameState), new ChessboardCoordinate(A, ONE));
//        placePiecesColumnMirroring(() -> new Rook(false, this, gameState), new ChessboardCoordinate(A, EIGHT));
//        placePiecesColumnMirroring(() -> new ClassicKnight(true, this, gameState), new ChessboardCoordinate(B, ONE));
//        placePiecesColumnMirroring(() -> new ClassicKnight(false, this, gameState), new ChessboardCoordinate(B, EIGHT));
//        placePiecesColumnMirroring(() -> new ClassicBishop(true, this, gameState), new ChessboardCoordinate(C, ONE));
//        placePiecesColumnMirroring(() -> new ClassicBishop(false, this, gameState), new ChessboardCoordinate(C, EIGHT));
//        placePiece(() -> new Queen(true, this, gameState), new ChessboardCoordinate(D, ONE));
//        placePiece(() -> new Queen(false, this, gameState), new ChessboardCoordinate(D, EIGHT));
//        placePiece(() -> new ClassicKing(true, this, gameState), new ChessboardCoordinate(E, ONE));
//        placePiece(() -> new ClassicKing(false, this, gameState), new ChessboardCoordinate(E, EIGHT));
//    }
//
//    @Override
//    public void placePiecesAtRow(Supplier<MoveRuledPiece> pieceSupplier, int rowIndex) {
//        throw new UnsupportedOperationException();
//    }
//
//    public ChessboardCoordinate getChessboardCoordinateOf(MoveRuledPiece moveRuledPiece) {
//        for(int i = 0; i <= fields.length; i++) {
//            for(int j = 0; j < fields[0].length; j++) {
//                if(moveRuledPiece == fields[i][j]) {
//                    return new ChessboardCoordinate(i, j);
//                }
//            }
//        }
//    }
//
//    public int getLastRowIndex() {
//        return fields.length - 1;
//    }
//
//    public int getLastColumnIndex() {
//        return fields[0].length - 1;
//    }
//
//    public int getFirstRowIndex() {
//        return 0;
//    }
//
//    public int getFirstColumnIndex() {
//        return 0;
//    }
//
//    public void move(ClassicChessMove classicChessMove) {
//        throw new UnsupportedOperationException();
//    }
//
//    private void placePiecesMirroringRows(Supplier<MoveRuledPiece> pieceSupplier, ChessboardRow chessboardRow) {
//        for (int i = 0; i < fields[0].length; i++) {
//            fields[chessboardRow.asArrayIndex()][i] = pieceSupplier.get();
//            fields[chessboardRow.mirrorRowAsArrayIndex()][i] = pieceSupplier.get();
//        }
//    }
//
//    private void placePiecesColumnsAndRowsMirroring(
//            Supplier<MoveRuledPiece> pieceSupplier, ChessboardCoordinate chessboardCoordinate) {
//        placePiece(pieceSupplier, chessboardCoordinate);
//        placePiece(pieceSupplier, chessboardCoordinate.mirrorByColumn());
//        placePiece(pieceSupplier, chessboardCoordinate.mirrorByRow());
//        placePiece(pieceSupplier, chessboardCoordinate.mirrorByRowAndColumn());
//    }
//
//    private void placePiecesColumnMirroring(Supplier<MoveRuledPiece> pieceSupplier, ChessboardCoordinate chessboardCoordinate) {
//        placePiece(pieceSupplier, chessboardCoordinate);
//        placePiece(pieceSupplier, chessboardCoordinate.mirrorByColumn());
//    }
//
//    private void placePiece(Supplier<MoveRuledPiece> pieceSupplier, ChessboardCoordinate chessboardCoordinate) {
//        fields[chessboardCoordinate.getChessboardRowAsArrayIndex()]
//                [chessboardCoordinate.getChessboardColumnAsArrayIndex()] = pieceSupplier.get();
//    }
//
//    public Optional<MoveRuledPiece> getPiece(ChessboardCoordinate coordinate) {
//        return Optional.ofNullable(
//                fields[coordinate.getChessboardRowAsArrayIndex()][coordinate.getChessboardColumnAsArrayIndex()]);
//    }
//
//    public boolean isFieldOccupiedAndPieceCanBeCaptured(ChessboardCoordinate coordinate) {
//        return getPiece(coordinate).map(MoveRuledPiece::canBeCaptured).orElse(false);
//    }
//
//    public Optional<MoveRuledPiece> getFirstPieceOfRow(ChessboardRow chessboardRow) {
//        throw new UnsupportedOperationException();
//    }
//
//    public Optional<MoveRuledPiece> getLastPieceOfRow(ChessboardRow chessboardRow) {
//        throw new UnsupportedOperationException();
//    }
//
//    public boolean isPieceAtAnyOf(Set<ChessboardCoordinate> chessboardCoordinates) {
//        getOccupiedChessboardCoordinates().stream().anyMatch()
//    }
//
//    public boolean isPieceAt(int rowIndex, int columnIndex) {
//
//    }
//
//    public Set<MoveRuledPiece> getAllPieces() {
//        throw new UnsupportedOperationException();
//    }
//
//    public Set<ChessboardCoordinate> getOccupiedChessboardCoordinates() {
//        var occupiedCoordinates = new HashSet<ChessboardCoordinate>();
//        for (int i = 0; i < fields.length; i++) {
//            for (int j = 0; j < fields[0].length; j++) {
//                if (fields[i][j] == null) {
//                    occupiedCoordinates.add(new ChessboardCoordinate(j, i));
//                }
//            }
//        }
//        return occupiedCoordinates;
//    }
//
//    public void print() {
//        for (MoveRuledPiece[] fieldsRow : fields) {
//            for (MoveRuledPiece field : fieldsRow) {
//                System.out.printf("[%s]", field == null ? "\u2001" : field);
//            }
//            System.out.println("");
//        }
//    }
//
//
//    public ClassicChessboard copyOf() {
//        throw new UnsupportedOperationException();
//    }
}
