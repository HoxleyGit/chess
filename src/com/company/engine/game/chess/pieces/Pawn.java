package com.company.engine.game.chess.pieces;

import com.company.engine.game.chess.pieces.attack.AttackingPiecesBoard;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiecesBoard;
import com.company.engine.game.chess.rule.classic.PawnClassicRule;
import com.company.engine.game.chess.pieces.attack.classic.PawnClassicAttackedCoordinatesFunction;
import com.company.engine.game.validation.rule.basic.PieceAtCoordinateMovedPredicate;

import java.util.function.Supplier;

public class Pawn extends ClassicPiece {

    public Pawn(boolean white,
                AttackingPiecesBoard board,
                PieceAtCoordinateMovedPredicate pieceAtCoordinateMovedPredicate,
                Supplier<Integer> movesCountSupplier) {
        this.white = white;
        this.moveRule = new PawnClassicRule(this, board, movesCountSupplier, pieceAtCoordinateMovedPredicate);
        this.attackedCoordinatesFunction = new PawnClassicAttackedCoordinatesFunction(this, board);
    }

    @Override
    public String toString() {
        return !white ? "\u2659" : "\u265F";
    }

    @Override
    public boolean canBePromoted() {
        return true;
    }
}
