package com.company.engine.game.chess.rule.classic;

import com.company.commons.move.PlaneMove;
import com.company.engine.game.validation.rule.basic.NoPieceFoundAtMoveTargetOrSoftCaptureMoveRule;

public class KnightClassicRule extends ClassicMoveRule {

    public KnightClassicRule(ClassicRuledPiece relatedPiece, ClassicRuledPiecesBoard board) {
        super(relatedPiece, board);
    }

    @Override
    public boolean test(PlaneMove move) {
        return super.test(move) &&
                move.isShortestLMove() &&
                new NoPieceFoundAtMoveTargetOrSoftCaptureMoveRule<>(relatedPiece, board).test(move);
    }
}
