package com.company.engine.game.chess.pieces.attack.classic;

import com.company.commons.move.IntegerCoordinate;
import com.company.engine.game.chess.pieces.attack.AttackedCoordinatesFunction;
import com.company.engine.game.chess.pieces.attack.AttackingPiecesBoard;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiece;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PawnClassicAttackedCoordinatesFunction extends AttackedCoordinatesFunction {

    public PawnClassicAttackedCoordinatesFunction(ClassicRuledPiece relatedPiece, AttackingPiecesBoard board) {
        super(relatedPiece, board);
    }

    @Override
    protected Set<IntegerCoordinate> getAttackedCoordinatesByRelatedPieceCoordinate(
            IntegerCoordinate relatedPieceCoordinate) {
        var relatedPieceColumnIndex = relatedPieceCoordinate.getColumnIndex();
        var relatedPieceRowIndex = relatedPieceCoordinate.getRowIndex();
        int attackedRowIndex = relatedPieceRowIndex - 1;
        if(relatedPiece.isWhite()) {
            attackedRowIndex = relatedPieceRowIndex + 1;
        }
        return Stream.of(
                new IntegerCoordinate(attackedRowIndex, relatedPieceColumnIndex + 1),
                new IntegerCoordinate(attackedRowIndex, relatedPieceColumnIndex - 1))
                .collect(Collectors.toSet());
    }
}
