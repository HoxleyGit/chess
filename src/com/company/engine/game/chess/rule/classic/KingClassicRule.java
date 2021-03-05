package com.company.engine.game.chess.rule.classic;

import com.company.commons.move.PlaneMove;
import com.company.engine.game.validation.rule.basic.*;

import java.util.function.Supplier;

public class KingClassicRule extends ClassicMoveRule {

    private final PieceAtCoordinateMovedPredicate pieceAtCoordinateMovedPredicate;

    public KingClassicRule(ClassicRuledPiece relatedPiece,
                           ClassicRuledPiecesBoard board,
                           Supplier<Integer> movesCountSupplier,
                           PieceAtCoordinateMovedPredicate pieceAtCoordinateMovedPredicate) {
        super(relatedPiece, board, movesCountSupplier);
        this.pieceAtCoordinateMovedPredicate = pieceAtCoordinateMovedPredicate;
    }

    @Override
    public boolean test(PlaneMove move) {
        return super.test(move) &&
                isSimpleKingMove(move) ||
                new ClassicKingCastleMove(board, pieceAtCoordinateMovedPredicate, relatedPiece).test(move);
    }

    private boolean isSimpleKingMove(PlaneMove move) {
        return move.isOneStepMove() &&
                new NoPieceFoundAtMoveTargetOrSoftCaptureMoveRule<>(relatedPiece, board).test(move);
    }
}
