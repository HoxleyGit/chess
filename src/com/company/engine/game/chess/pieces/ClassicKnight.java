package com.company.engine.game.chess.pieces;

import com.company.engine.game.chess.pieces.attack.AttackingPiecesBoard;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiecesBoard;
import com.company.engine.game.chess.rule.classic.KnightClassicRule;
import com.company.engine.game.chess.pieces.attack.classic.KnightClassicAttackedCoordinatesFunction;

import java.util.function.Supplier;

public class ClassicKnight extends ClassicPiece {

    public ClassicKnight(boolean white, AttackingPiecesBoard board, Supplier<Integer> movesCountSupplier) {
        this.white = white;
        this.moveRule = new KnightClassicRule(this, board, movesCountSupplier);
        this.attackedCoordinatesFunction = new KnightClassicAttackedCoordinatesFunction(this);
    }

    @Override
    public String toString() {
        return !white ? "\u2658" : "\u265E";
    }
}
