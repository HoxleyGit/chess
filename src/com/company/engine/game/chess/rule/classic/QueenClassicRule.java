package com.company.engine.game.chess.rule.classic;

import com.company.commons.move.PlaneMove;

import java.util.function.Supplier;

public class QueenClassicRule extends ClassicMoveRule {

    public QueenClassicRule(
            ClassicRuledPiece relatedPiece, ClassicRuledPiecesBoard board, Supplier<Integer> movesCountSupplier) {
        super(relatedPiece, board, movesCountSupplier);
    }

    @Override
    public boolean test(PlaneMove move) {
        return super.test(move) &&
                new BishopClassicRule(relatedPiece, board, movesCountSupplier).test(move) ||
                new RookClassicRule(relatedPiece, board, movesCountSupplier).test(move);
    }
}
