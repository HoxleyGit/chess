package com.company.engine.game.chess.pieces;

import com.company.engine.game.chess.chessboard.ClassicChessboard;
import com.company.engine.game.chess.game.GameState;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiecesBoard;
import com.company.engine.game.chess.rule.classic.PawnClassicRule;
import com.company.engine.game.chess.pieces.attack.classic.PawnClassicAttackedCoordinatesFunction;
import com.company.engine.game.validation.rule.MoveRuledPiece;
import com.company.engine.game.validation.rule.basic.PieceAtCoordinateMovedPredicate;

public class Pawn extends ClassicPiece {

    public Pawn(boolean white,
                ClassicRuledPiecesBoard board,
                PieceAtCoordinateMovedPredicate pieceAtCoordinateMovedPredicate) {
        this.white = white;
        this.moveRule = new PawnClassicRule(this, board, pieceAtCoordinateMovedPredicate);
        this.attackedCoordinatesFunction = new PawnClassicAttackedCoordinatesFunction(this, board);
    }

    @Override
    public String toString() {
        return "\u2659";
    }
}
