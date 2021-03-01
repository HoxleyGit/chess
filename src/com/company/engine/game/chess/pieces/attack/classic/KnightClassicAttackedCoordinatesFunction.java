package com.company.engine.game.chess.pieces.attack.classic;

import com.company.engine.game.chess.pieces.attack.AttackedCoordinatesFunction;
import com.company.engine.game.chess.chessboard.ClassicChessboard;
import com.company.engine.game.chess.chessboard.ChessboardCoordinate;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiece;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiecesBoard;
import com.company.pieces.Piece;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KnightClassicAttackedCoordinatesFunction extends AttackedCoordinatesFunction {
    public KnightClassicAttackedCoordinatesFunction(ClassicRuledPiece relatedPiece, ClassicRuledPiecesBoard classicChessboard) {
        super(relatedPiece, classicChessboard);
    }

    @Override
    public Set<ChessboardCoordinate> apply(Piece piece) {
        var pieceCoordinates = classicChessboard.getChessboardCoordinateOf(piece);
        var pieceRowIndex = pieceCoordinates.getChessboardRowAsArrayIndex();
        var pieceColumnIndex = pieceCoordinates.getChessboardColumnAsArrayIndex();
        return Stream.of(
                ChessboardCoordinate.of(pieceColumnIndex + 1, pieceRowIndex + 2),
                ChessboardCoordinate.of(pieceColumnIndex + 2, pieceRowIndex + 1),
                ChessboardCoordinate.of(pieceColumnIndex + 1, pieceRowIndex - 2),
                ChessboardCoordinate.of(pieceColumnIndex + 2, pieceRowIndex - 1),
                ChessboardCoordinate.of(pieceColumnIndex - 1, pieceRowIndex - 2),
                ChessboardCoordinate.of(pieceColumnIndex - 2, pieceRowIndex - 1),
                ChessboardCoordinate.of(pieceColumnIndex - 1, pieceRowIndex + 2),
                ChessboardCoordinate.of(pieceColumnIndex - 2, pieceRowIndex + 1))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
    }
}
