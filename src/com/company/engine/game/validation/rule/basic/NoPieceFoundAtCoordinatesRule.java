package com.company.engine.game.validation.rule.basic;

import com.company.commons.move.IntegerCoordinate;
import com.company.commons.move.PlaneMove;
import com.company.engine.game.validation.rule.MoveRule;

import java.util.Set;

public class NoPieceFoundAtCoordinatesRule<TPiece extends BasicRuledPiece> implements MoveRule {

    private final Set<IntegerCoordinate> validatedCoordinates;

    private final BasicRuledPiecesBoard<TPiece> board;

    public NoPieceFoundAtCoordinatesRule(Set<IntegerCoordinate> validatedCoordinates,
                                         BasicRuledPiecesBoard<TPiece> board) {
        this.validatedCoordinates = validatedCoordinates;
        this.board = board;
    }

    @Override
    public boolean test(PlaneMove move) {
        return validatedCoordinates.stream().noneMatch(board.getOccupiedCoordinates()::contains);
    }
}
