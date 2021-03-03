package com.company.engine.game.chess.pieces;

import com.company.commons.move.IntegerCoordinate;
import com.company.engine.game.chess.pieces.attack.AttackedCoordinatesFunction;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiece;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiecesBoard;
import com.company.engine.game.validation.rule.MoveRule;

import java.util.Set;

public abstract class ClassicPiece implements ClassicRuledPiece {

    protected boolean white;

    protected MoveRule moveRule;

    protected AttackedCoordinatesFunction attackedCoordinatesFunction;

    @Override
    public boolean isWhite() {
        return white;
    }

    @Override
    public Set<IntegerCoordinate> getAttackedCoordinates(ClassicRuledPiecesBoard board) {
        return attackedCoordinatesFunction.apply(board);
    }

    @Override
    public MoveRule getMoveRule() {
        return moveRule;
    }

    @Override
    public boolean isCheckable() {
        return false;
    }

    @Override
    public boolean canCastle() {
        return false;
    }

    @Override
    public boolean canBePromoted() {
        return false;
    }
}
