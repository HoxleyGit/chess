package com.company.engine.game.chess.pieces;

import com.company.engine.game.chess.pieces.attack.AttackingPiecesBoard;
import com.company.engine.game.chess.rule.classic.RookClassicRule;
import com.company.engine.game.chess.pieces.attack.classic.RookClassicAttackedCoordinatesFunction;

public class Rook extends ClassicPiece {

    public Rook(boolean white, AttackingPiecesBoard board) {
        this.white = white;
        this.moveRule = new RookClassicRule(this, board);
        this.attackedCoordinatesFunction = new RookClassicAttackedCoordinatesFunction(this, board);
    }

    @Override
    public String toString() {
        return white ? "\u2656" : "\u265C";
    }
}
