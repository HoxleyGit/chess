package com.company.engine.game.chess.game;

import com.company.engine.game.Board;
import com.company.engine.game.MoveValidator;
import com.company.commons.move.PlaneMove;

public class SimpleMoveValidator implements MoveValidator {

    private final Board board;

    public SimpleMoveValidator(Board board) {
        this.board = board;
    }

    @Override
    public boolean isValid(PlaneMove planeMove) {
        return board.getPiece(planeMove.getSource())
                .map(piece -> piece.getMoveRule().test(planeMove))
                .orElse(false);
    }
}
