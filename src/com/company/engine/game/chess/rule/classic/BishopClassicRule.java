package com.company.engine.game.chess.rule.classic;

import com.company.commons.move.PlaneMove;
import com.company.engine.game.validation.rule.basic.NoPieceFoundAtCoordinatesAndNoPieceAtMoveTargetOrSoftCaptureMoveRule;

public class BishopClassicRule extends ClassicMoveRule {

    public BishopClassicRule(ClassicRuledPiece relatedPiece, ClassicRuledPiecesBoard board) {
        super(relatedPiece, board);
    }

    @Override
    public boolean test(PlaneMove move) {
        return super.test(move) &&
                move.isDiagonalMove() &&
                new NoPieceFoundAtCoordinatesAndNoPieceAtMoveTargetOrSoftCaptureMoveRule<>(
                        board.getCoordinatesBetweenDiagonally(move), relatedPiece, board).test(move);
    }
}
