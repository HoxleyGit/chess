package com.company.engine.game.chess.pieces;

import com.company.engine.game.chess.rule.classic.BishopClassicRule;
import com.company.engine.game.chess.pieces.attack.classic.BishopClassicAttackedCoordinatesFunction;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiecesBoard;

public class ClassicBishop extends ClassicPiece {

    public ClassicBishop(boolean white, ClassicRuledPiecesBoard board) {
        this.white = white;
        this.moveRule = new BishopClassicRule(this, board);
        this.attackedCoordinatesFunction = new BishopClassicAttackedCoordinatesFunction(this, board);
    }

    @Override
    public String toString() {
        return "\u2657";
    }
}