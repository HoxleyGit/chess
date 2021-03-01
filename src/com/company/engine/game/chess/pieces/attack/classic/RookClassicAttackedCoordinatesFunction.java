package com.company.engine.game.chess.pieces.attack.classic;

import com.company.engine.game.chess.pieces.attack.AttackedCoordinatesFunction;
import com.company.engine.game.chess.chessboard.ClassicChessboard;
import com.company.engine.game.chess.chessboard.ChessboardCoordinate;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiece;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiecesBoard;
import com.company.pieces.Piece;

import java.util.Set;

public class RookClassicAttackedCoordinatesFunction extends AttackedCoordinatesFunction {

    public RookClassicAttackedCoordinatesFunction(ClassicRuledPiece relatedPiece, ClassicRuledPiecesBoard classicChessboard) {
        super(relatedPiece, classicChessboard);
    }

    @Override
    public Set<ChessboardCoordinate> apply(Piece piece) {
        throw new UnsupportedOperationException();
/*        var pieceCoordinate = chessboard.getChessboardCoordinateOf(piece);
        var pieceRowIndex = pieceCoordinate.getChessboardRow().asArrayIndex();
        var pieceColumnIndex = pieceCoordinate.getChessboardColumn().asArrayIndex();
        var attackedCoordinates = new HashSet<ChessboardCoordinate>();
        for(int i = pieceRowIndex; i < chessboard.getLastRowIndex(); i++) {
            var coordinate = new ChessboardCoordinate(i, pieceColumnIndex);
            var foundPiece = chessboard.getPiece(coordinate);
            if(foundPiece.isPresent() && foundPiece.get().isWhite() == isWhite) {
                break;
            }
            if(foundPiece.isPresent() && foundPiece.get().isWhite() != isWhite) {
                attackedCoordinates.add(coordinate);
                break;
            }
            attackedCoordinates.add(coordinate);
        }

        for(int i = pieceRowIndex; i >= chessboard.getFirstRowIndex(); i--) {
            var coordinate = new ChessboardCoordinate(i, pieceColumnIndex);
            var foundPiece = chessboard.getPiece(coordinate);
            if(foundPiece.isPresent() && foundPiece.get().isWhite() == isWhite) {
                break;
            }
            if(foundPiece.isPresent() && foundPiece.get().isWhite() != isWhite) {
                attackedCoordinates.add(coordinate);
                break;
            }
            attackedCoordinates.add(coordinate);
        }*/
    }
}
