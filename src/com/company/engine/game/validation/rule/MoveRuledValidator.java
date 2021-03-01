package com.company.engine.game.validation.rule;

import com.company.commons.move.PlaneMove;
import com.company.engine.game.MoveValidator;

public class MoveRuledValidator<TPiece extends MoveRuledPiece> implements MoveValidator {

    private final MoveRuledBoard<TPiece> board;

    public MoveRuledValidator(MoveRuledBoard<TPiece> board) {
        this.board = board;
    }

    @Override
    public boolean isValid(PlaneMove planeMove) {
        return board.getPiece(planeMove.getSource())
                .map(piece -> piece.getMoveRule().test(planeMove))
                .orElse(false);
    }
}
