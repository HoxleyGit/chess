package com.company.engine.game.chess.pieces.attack.classic;

import com.company.commons.move.IntegerCoordinate;
import com.company.engine.game.chess.pieces.attack.AttackedCoordinatesFunction;
import com.company.engine.game.chess.pieces.attack.AttackingPiecesBoard;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiece;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiecesBoard;

import java.util.HashSet;
import java.util.Set;

public class QueenClassicAttackedCoordinatesFunction extends AttackedCoordinatesFunction {

    public QueenClassicAttackedCoordinatesFunction(ClassicRuledPiece relatedPiece) {
        super(relatedPiece);
    }

    @Override
    protected Set<IntegerCoordinate> getAttackedCoordinatesByRelatedPieceCoordinate(
            IntegerCoordinate relatedPieceCoordinate, ClassicRuledPiecesBoard board) {
        var attackedCoordinates = new HashSet<IntegerCoordinate>();
        attackedCoordinates.addAll(new RookClassicAttackedCoordinatesFunction(relatedPiece).apply(board));
        attackedCoordinates.addAll(new BishopClassicAttackedCoordinatesFunction(relatedPiece).apply(board));
        return attackedCoordinates;
    }
}
