package com.company.engine.game.chess.rule.classic;

import com.company.commons.move.PlaneMove;
import com.company.engine.game.validation.rule.basic.NoPieceFoundAtCoordinatesAndNoPieceAtMoveTargetOrSoftCaptureMoveRule;

import java.util.function.Supplier;

public class RookClassicRule extends ClassicMoveRule {

    public RookClassicRule(
            ClassicRuledPiece relatedPiece, ClassicRuledPiecesBoard board, Supplier<Integer> movesCountSupplier) {
        super(relatedPiece, board, movesCountSupplier);
    }

    @Override
    public boolean test(PlaneMove move) {
        return super.test(move) &&
                move.isStraightMove() &&
                new NoPieceFoundAtCoordinatesAndNoPieceAtMoveTargetOrSoftCaptureMoveRule<>(
                        board.getCoordinatesBetweenStraight(move), relatedPiece, board).test(move);
    }
}
