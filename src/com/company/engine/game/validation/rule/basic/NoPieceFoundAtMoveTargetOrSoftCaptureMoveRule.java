package com.company.engine.game.validation.rule.basic;

import com.company.commons.move.PlaneMove;
import com.company.engine.game.validation.rule.MoveRule;

public class NoPieceFoundAtMoveTargetOrSoftCaptureMoveRule<TPiece extends BasicRuledPiece> implements MoveRule {

    private final TPiece relatedPiece;

    private final BasicRuledPiecesBoard<TPiece> board;

    public NoPieceFoundAtMoveTargetOrSoftCaptureMoveRule(TPiece relatedPiece, BasicRuledPiecesBoard<TPiece> board) {
        this.relatedPiece = relatedPiece;
        this.board = board;
    }

    @Override
    public boolean test(PlaneMove move) {
        return new NoPieceFoundAtMoveTargetRule<>(board).test(move) ||
                new SoftCaptureMoveRule<>(board, relatedPiece).test(move);
    }
}
