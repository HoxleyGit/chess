package com.company.engine.game.chess.pieces;

import com.company.engine.game.chess.rule.classic.ClassicRuledPiecesBoard;
import com.company.engine.game.chess.rule.classic.KnightClassicRule;
import com.company.engine.game.chess.pieces.attack.classic.KnightClassicAttackedCoordinatesFunction;

public class ClassicKnight extends ClassicPiece {

    public ClassicKnight(boolean white, ClassicRuledPiecesBoard board) {
        this.white = white;
        this.moveRule = new KnightClassicRule(this, board);
        this.attackedCoordinatesFunction = new KnightClassicAttackedCoordinatesFunction(this, board);
    }

    @Override
    public String toString() {
        return "\u2658";
    }
}
