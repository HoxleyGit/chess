package com.company.engine.game.validation.rule.basic;

import com.company.commons.move.PlaneMove;
import com.company.engine.game.validation.rule.MoveRule;

public class OnlyFirstMoveRule implements MoveRule {

    private final PieceAtCoordinateMovedPredicate alreadyMovedPredicate;

    public OnlyFirstMoveRule(PieceAtCoordinateMovedPredicate alreadyMovedPredicate) {
        this.alreadyMovedPredicate = alreadyMovedPredicate;
    }

    @Override
    public boolean test(PlaneMove move) {
        return !alreadyMovedPredicate.wasPieceAtCoordinateMoved(move.getSource());
    }
}
