package com.company.engine.game.chess.rule.classic;

import com.company.commons.move.PlaneMove;
import com.company.engine.game.validation.rule.MoveRule;
import com.company.engine.game.validation.rule.basic.PieceAtCoordinateMovedPredicate;

import static com.company.engine.game.chess.rule.classic.ClassicCasteKingAssistantMoveDirection.FROM_LEFT;

public class ClassicKingLeftCastleMove extends ClassicKingCastleBaseMoveRule {

    public ClassicKingLeftCastleMove(
            ClassicRuledPiecesBoard board, PieceAtCoordinateMovedPredicate pieceAtCoordinateMovedPredicate) {
        super(board, pieceAtCoordinateMovedPredicate);
    }

    @Override
    public boolean test(PlaneMove move) {
        return super.test(move) &&
                move.isNStepLeftStraightMove(2) &&
                canKingAssistantCastle(move.getSource(), FROM_LEFT);
    }
}
