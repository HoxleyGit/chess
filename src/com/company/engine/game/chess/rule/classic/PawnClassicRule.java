package com.company.engine.game.chess.rule.classic;

import com.company.commons.move.PlaneMove;
import com.company.engine.game.validation.rule.basic.*;

import java.util.function.IntPredicate;
import java.util.function.Supplier;

public class PawnClassicRule extends ClassicMoveRule {

    private final PieceAtCoordinateMovedPredicate pieceAtCoordinateMovedPredicate;

    public PawnClassicRule(ClassicRuledPiece relatedPiece,
                           ClassicRuledPiecesBoard board,
                           Supplier<Integer> movesCountSupplier,
                           PieceAtCoordinateMovedPredicate pieceAtCoordinateMovedPredicate) {
        super(relatedPiece, board, movesCountSupplier);
        this.pieceAtCoordinateMovedPredicate = pieceAtCoordinateMovedPredicate;
    }

    @Override
    public boolean test(PlaneMove move) {
        return super.test(move) && isNoCaptureMoveValid(move) || isCaptureMoveValid(move);
    }

    private boolean isNoCaptureMoveValid(PlaneMove move) {
        IntPredicate isPawnNStepStraightMove =
                nStep ->  relatedPiece.isWhite() ?  move.isNStepForwardStraightMove(nStep) : move.isNStepBackwardStraightMove(nStep);

        return new NoPieceFoundAtMoveTargetRule<>(board).test(move) &&
                (isPawnNStepStraightMove.test(1) ||
                        (isPawnNStepStraightMove.test(2) &&
                                new OnlyFirstMoveRule(pieceAtCoordinateMovedPredicate).test(move) &&
                                new NoPieceFoundAtCoordinatesRule<>(
                                        board.getCoordinatesBetweenStraight(move), board).test(move)));
    }

    private boolean isCaptureMoveValid(PlaneMove move) {
        return (relatedPiece.isWhite() ? move.isNStepForwardDiagonalMove(1) : move.isNStepBackwardDiagonalMove(1)) &&
                new SoftCaptureMoveRule<>(board, relatedPiece).test(move);
    }
}
