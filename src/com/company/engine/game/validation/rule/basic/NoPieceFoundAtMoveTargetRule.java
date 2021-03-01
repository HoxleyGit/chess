package com.company.engine.game.validation.rule.basic;

import com.company.commons.move.PlaneMove;
import com.company.engine.game.validation.rule.MoveRule;

public class NoPieceFoundAtMoveTargetRule<TPiece extends BasicRuledPiece> implements MoveRule {

    private final BasicRuledPiecesBoard<TPiece> board;

    public NoPieceFoundAtMoveTargetRule(BasicRuledPiecesBoard<TPiece> board) {
        this.board = board;
    }

    @Override
    public boolean test(PlaneMove move) {
        return board.getPiece(move.getTarget()).isEmpty();
    }
}
