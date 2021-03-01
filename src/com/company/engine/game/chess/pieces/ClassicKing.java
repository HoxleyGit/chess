package com.company.engine.game.chess.pieces;

import com.company.engine.game.chess.pieces.attack.AttackingPiecesBoard;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiecesBoard;
import com.company.engine.game.chess.rule.classic.KingClassicRule;
import com.company.engine.game.chess.pieces.attack.classic.KingClassicAttackedCoordinates;
import com.company.engine.game.validation.rule.basic.PieceAtCoordinateMovedPredicate;

public class ClassicKing extends ClassicPiece {

    public ClassicKing(boolean white,
                       AttackingPiecesBoard board,
                       PieceAtCoordinateMovedPredicate pieceAtCoordinateMovedPredicate) {
        this.white = white;
        this.moveRule = new KingClassicRule(this, board, pieceAtCoordinateMovedPredicate);
        this.attackedCoordinatesFunction = new KingClassicAttackedCoordinates(this, board);
    }

    @Override
    public boolean isCheckable() {
        return true;
    }

    @Override
    public String toString() {
        return white ? "\u2654" : "\u265A";
    }
}
