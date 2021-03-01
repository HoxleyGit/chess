package com.company.engine.game.chess.pieces;

import com.company.engine.game.chess.pieces.attack.AttackingPiecesBoard;
import com.company.engine.game.chess.rule.classic.BishopClassicRule;
import com.company.engine.game.chess.pieces.attack.classic.BishopClassicAttackedCoordinatesFunction;

public class ClassicBishop extends ClassicPiece {

    public ClassicBishop(boolean white, AttackingPiecesBoard board) {
        this.white = white;
        this.moveRule = new BishopClassicRule(this, board);
        this.attackedCoordinatesFunction = new BishopClassicAttackedCoordinatesFunction(this, board);
    }

    @Override
    public String toString() {
        return white ? "\u2657" : "\u265D";
    }
}
