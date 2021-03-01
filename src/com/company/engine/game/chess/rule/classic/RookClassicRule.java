package com.company.engine.game.chess.rule.classic;

import com.company.commons.move.PlaneMove;
import com.company.engine.game.validation.rule.basic.NoPieceFoundAtCoordinatesAndNoPieceAtMoveTargetOrSoftCaptureMoveRule;

public class RookClassicRule extends ClassicMoveRule {

    public RookClassicRule(ClassicRuledPiece relatedPiece, ClassicRuledPiecesBoard board) {
        super(relatedPiece, board);
    }

    @Override
    public boolean test(PlaneMove move) {
        return super.test(move) &&
                move.isStraightMove() &&
                new NoPieceFoundAtCoordinatesAndNoPieceAtMoveTargetOrSoftCaptureMoveRule<>(
                        board.getAllChessCoordinatesBetweenStraight(move), relatedPiece, board).test(move);
    }
}
