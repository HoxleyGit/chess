package com.company.engine.game.validation.rule.basic;

import com.company.commons.move.PlaneMove;
import com.company.engine.game.validation.rule.MoveRule;

public class SoftCaptureMoveRule<TPiece extends BasicRuledPiece> implements MoveRule {

    private final BasicRuledPiecesBoard<TPiece> board;

    private final TPiece relatedPiece;

    public SoftCaptureMoveRule(BasicRuledPiecesBoard<TPiece> board, TPiece relatedPiece) {
        this.board = board;
        this.relatedPiece = relatedPiece;
    }

    @Override
    public boolean test(PlaneMove move) {
        return board.getPiece(move.getTarget())
                .map(piece -> piece.isWhite() != relatedPiece.isWhite())
                .orElse(false);
    }
}
