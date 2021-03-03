package com.company.engine.game.chess.pieces.attack.classic;

import com.company.commons.move.IntegerCoordinate;
import com.company.engine.game.chess.pieces.attack.AttackedCoordinatesFunction;
import com.company.engine.game.chess.pieces.attack.AttackingPiecesBoard;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiece;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiecesBoard;

import java.util.Set;

public class KnightClassicAttackedCoordinatesFunction extends AttackedCoordinatesFunction {

    public KnightClassicAttackedCoordinatesFunction(ClassicRuledPiece relatedPiece) {
        super(relatedPiece);
    }

    @Override
    protected Set<IntegerCoordinate> getAttackedCoordinatesByRelatedPieceCoordinate(
            IntegerCoordinate relatedPieceCoordinate, ClassicRuledPiecesBoard board) {
        return relatedPieceCoordinate.getAllShortestLMoveTargetCoordinates();
    }
}
