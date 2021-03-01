package com.company.engine.game.chess.pieces.attack.classic;

import com.company.engine.game.chess.pieces.attack.AttackedCoordinatesFunction;
import com.company.engine.game.chess.chessboard.ChessboardCoordinate;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiece;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiecesBoard;
import com.company.pieces.Piece;

import java.util.Set;

public class BishopClassicAttackedCoordinatesFunction extends AttackedCoordinatesFunction {

    public BishopClassicAttackedCoordinatesFunction(ClassicRuledPiece relatedPiece, ClassicRuledPiecesBoard classicChessboard) {
        super(relatedPiece, classicChessboard);
    }

    @Override
    public Set<ChessboardCoordinate> apply(Piece piece) {
        var pieceCoordinate = classicChessboard.getChessboardCoordinateOf(piece);
        var attackedCoordinates =
                getCoordinatesDiagonallyUntilOccupied(pieceCoordinate, true, true);
        attackedCoordinates.addAll(getCoordinatesDiagonallyUntilOccupied(pieceCoordinate, true, false));
        attackedCoordinates.addAll(getCoordinatesDiagonallyUntilOccupied(pieceCoordinate, false, true));
        attackedCoordinates.addAll(getCoordinatesDiagonallyUntilOccupied(pieceCoordinate, false, false));
        return attackedCoordinates;
    }

    private Set<ChessboardCoordinate> getCoordinatesDiagonallyUntilOccupied(
            ChessboardCoordinate chessboardCoordinate, boolean rowUp, boolean columnUp) {
        throw new UnsupportedOperationException();
/*        IntPredicate rowPredicate =
                i -> rowUp ? i < chessboard.getLastRowIndex() : i >= chessboard.getFirstRowIndex();
        IntPredicate columnPredicate =
                j -> columnUp ? j < chessboard.getLastColumnIndex() : j >= chessboard.getFirstColumnIndex();
        IntUnaryOperator newRowIndexFunction = i -> rowUp ? ++i : --i;
        IntUnaryOperator newColumnIndexFunction = j -> columnUp ? ++j : --j;
        var pieceRowIndex = chessboardCoordinate.getChessboardRow().asArrayIndex();
        var pieceColumnIndex = chessboardCoordinate.getChessboardColumn().asArrayIndex();
        var attackedCoordinates = new HashSet<ChessboardCoordinate>();
        boolean breakNextTime = false;
        for(int i = pieceRowIndex; rowPredicate.test(i); i = newRowIndexFunction.applyAsInt(i)) {
            for(int j = pieceColumnIndex; columnPredicate.test(j); j = newColumnIndexFunction.applyAsInt(j)) {
                var chessboardCoordinates = new ChessboardCoordinate(i, j);
                var piece = chessboard.getPiece(chessboardCoordinates);
                if(piece.map(p -> p.isWhite() == isWhite).orElse(false) || breakNextTime) {
                    break;
                }
                if(piece.isEmpty()) {
                    attackedCoordinates.add(new ChessboardCoordinate(i, j));
                }
                attackedCoordinates.add(new ChessboardCoordinate(i, j));
                breakNextTime = true;
            }
        }
        return attackedCoordinates;*/
    }
}
