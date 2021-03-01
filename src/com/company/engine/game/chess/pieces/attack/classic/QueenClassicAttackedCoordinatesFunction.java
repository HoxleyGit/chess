package com.company.engine.game.chess.pieces.attack.classic;

import com.company.commons.move.IntegerCoordinate;
import com.company.engine.game.chess.pieces.attack.AttackedCoordinatesFunction;
import com.company.engine.game.chess.pieces.attack.AttackingPiecesBoard;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiece;

import java.util.HashSet;
import java.util.Set;

public class QueenClassicAttackedCoordinatesFunction extends AttackedCoordinatesFunction {

    public QueenClassicAttackedCoordinatesFunction(ClassicRuledPiece relatedPiece, AttackingPiecesBoard board) {
        super(relatedPiece, board);
    }

    @Override
    protected Set<IntegerCoordinate> getAttackedCoordinatesByRelatedPieceCoordinate(
            IntegerCoordinate relatedPieceCoordinate) {
        var attackedCoordinates = new HashSet<IntegerCoordinate>();
        attackedCoordinates.addAll(new RookClassicAttackedCoordinatesFunction(relatedPiece, board).get());
        attackedCoordinates.addAll(new BishopClassicAttackedCoordinatesFunction(relatedPiece, board).get());
        return attackedCoordinates;
    }
}
