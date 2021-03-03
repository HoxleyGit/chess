package com.company.engine.game.chess.rule.classic;

import com.company.commons.move.PlaneMove;
import com.company.engine.game.validation.rule.basic.PieceAtCoordinateMovedPredicate;

import static com.company.engine.game.chess.rule.classic.ClassicCasteKingAssistantMoveDirection.FROM_LEFT;
import static com.company.engine.game.chess.rule.classic.ClassicCasteKingAssistantMoveDirection.FROM_RIGHT;

public class ClassicKingRightCastleMove extends ClassicKingCastleBaseMoveRule {

    public ClassicKingRightCastleMove(
            ClassicRuledPiecesBoard board, PieceAtCoordinateMovedPredicate pieceAtCoordinateMovedPredicate) {
        super(board, pieceAtCoordinateMovedPredicate);
    }

    @Override
    public boolean test(PlaneMove move) {
        return super.test(move) &&
                move.isNStepRightStraightMove(2) &&
                canKingAssistantCastle(move.getSource(), FROM_RIGHT);
    }
}
