package com.company.engine.game.chess.pieces.attack.classic;

import com.company.commons.move.IntegerCoordinate;
import com.company.engine.game.chess.pieces.attack.AttackedCoordinatesFunction;
import com.company.engine.game.chess.pieces.attack.AttackingPiecesBoard;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiece;

import java.util.Set;

public class KingClassicAttackedCoordinates extends AttackedCoordinatesFunction {

    public KingClassicAttackedCoordinates(ClassicRuledPiece relatedPiece, AttackingPiecesBoard board) {
        super(relatedPiece, board);
    }

    @Override
    protected Set<IntegerCoordinate> getAttackedCoordinatesByRelatedPieceCoordinate(
            IntegerCoordinate relatedPieceCoordinate) {
        return relatedPieceCoordinate.getAllAdjacentCoordinates();
    }
}
