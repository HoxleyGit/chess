package com.company.engine.game.chess.pieces;

import com.company.engine.game.chess.pieces.attack.AttackingPiecesBoard;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiecesBoard;
import com.company.engine.game.chess.rule.classic.QueenClassicRule;
import com.company.engine.game.chess.pieces.attack.classic.QueenClassicAttackedCoordinatesFunction;

import java.util.function.Supplier;

public class Queen extends ClassicPiece {

    public Queen(boolean white, AttackingPiecesBoard board, Supplier<Integer> movesCountSupplier) {
        this.white = white;
        this.moveRule = new QueenClassicRule(this, board, movesCountSupplier);
        this.attackedCoordinatesFunction = new QueenClassicAttackedCoordinatesFunction(this, board);
    }

    @Override
    public String toString() {
        return !white ? "\u2655" : "\u265B";
    }
}
