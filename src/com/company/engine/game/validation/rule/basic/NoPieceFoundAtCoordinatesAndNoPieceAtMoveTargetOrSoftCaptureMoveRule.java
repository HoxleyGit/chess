package com.company.engine.game.validation.rule.basic;

import com.company.commons.move.IntegerCoordinate;
import com.company.commons.move.PlaneMove;
import com.company.engine.game.validation.rule.MoveRule;

import java.util.Set;

public class NoPieceFoundAtCoordinatesAndNoPieceAtMoveTargetOrSoftCaptureMoveRule<TPiece extends BasicRuledPiece>
        implements MoveRule {

    private final Set<IntegerCoordinate> validatedCoordinates;

    private final TPiece relatedPiece;

    private final BasicRuledPiecesBoard<TPiece> board;

    public NoPieceFoundAtCoordinatesAndNoPieceAtMoveTargetOrSoftCaptureMoveRule(
            Set<IntegerCoordinate> validatedCoordinates,
            TPiece relatedPiece,
            BasicRuledPiecesBoard<TPiece> board) {
        this.validatedCoordinates = validatedCoordinates;
        this.relatedPiece = relatedPiece;
        this.board = board;
    }

    @Override
    public boolean test(PlaneMove move) {
        return new NoPieceFoundAtCoordinatesRule<>(validatedCoordinates, board).test(move) &&
                new NoPieceFoundAtMoveTargetOrSoftCaptureMoveRule<>(relatedPiece, board).test(move);
    }
}
