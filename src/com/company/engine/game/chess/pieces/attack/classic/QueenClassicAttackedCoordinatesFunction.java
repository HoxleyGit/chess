package com.company.engine.game.chess.pieces.attack.classic;

import com.company.engine.game.chess.pieces.attack.AttackedCoordinatesFunction;
import com.company.engine.game.chess.chessboard.ClassicChessboard;
import com.company.engine.game.chess.chessboard.ChessboardCoordinate;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiece;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiecesBoard;
import com.company.pieces.Piece;

import java.util.HashSet;
import java.util.Set;

public class QueenClassicAttackedCoordinatesFunction extends AttackedCoordinatesFunction {

    public QueenClassicAttackedCoordinatesFunction(ClassicRuledPiece relatedPiece, ClassicRuledPiecesBoard classicChessboard) {
        super(relatedPiece, classicChessboard);
    }

    @Override
    public Set<ChessboardCoordinate> apply(Piece piece) {
        var attackedCoordinates = new HashSet<ChessboardCoordinate>();
        attackedCoordinates.addAll(new RookClassicAttackedCoordinatesFunction(classicChessboard, isWhite).apply(piece));
        attackedCoordinates.addAll(new BishopClassicAttackedCoordinatesFunction(classicChessboard, isWhite).apply(piece));
        return attackedCoordinates;
    }
}
