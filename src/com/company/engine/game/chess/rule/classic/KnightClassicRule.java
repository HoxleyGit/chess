package com.company.engine.game.chess.rule.classic;

import com.company.commons.move.PlaneMove;
import com.company.engine.game.validation.rule.basic.NoPieceFoundAtMoveTargetOrSoftCaptureMoveRule;

import java.util.function.Supplier;

public class KnightClassicRule extends ClassicMoveRule {

    public KnightClassicRule(
            ClassicRuledPiece relatedPiece, ClassicRuledPiecesBoard board, Supplier<Integer> movesCountSupplier) {
        super(relatedPiece, board, movesCountSupplier);
    }

    @Override
    public boolean test(PlaneMove move) {
        return super.test(move) &&
                move.isShortestLMove() &&
                new NoPieceFoundAtMoveTargetOrSoftCaptureMoveRule<>(relatedPiece, board).test(move);
    }
}
