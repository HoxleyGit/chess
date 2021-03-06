package com.company.engine.game.chess.pieces;

import com.company.engine.game.chess.pieces.attack.AttackingPiecesBoard;
import com.company.engine.game.chess.rule.classic.BishopClassicRule;
import com.company.engine.game.chess.pieces.attack.classic.BishopClassicAttackedCoordinatesFunction;

import java.util.function.Supplier;

public class ClassicBishop extends ClassicPiece {

    public ClassicBishop(boolean white, AttackingPiecesBoard board, Supplier<Integer> movesCountSupplier) {
        this.white = white;
        this.moveRule = new BishopClassicRule(this, board, movesCountSupplier);
        this.attackedCoordinatesFunction = new BishopClassicAttackedCoordinatesFunction(this);
    }

    @Override
    public String toString() {
        return white ? "\u265D" : "\u2657";
    }
}
