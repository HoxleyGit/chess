package com.company.engine.game.chess.rule.classic;

import com.company.commons.move.IntegerCoordinate;
import com.company.commons.move.PlaneMove;

public class KingAssistantMoveUtil {

    public static PlaneMove createKingAssistantCastleMove(
            IntegerCoordinate actualKingCoordinate,
            ClassicCasteKingAssistantMoveDirection classicCasteKingAssistantMoveDirection,
            ClassicRuledPiecesBoard board) {
        var kingActualRow = actualKingCoordinate.getRowIndex();
        return new PlaneMove(
                new IntegerCoordinate(kingActualRow,
                        classicCasteKingAssistantMoveDirection.getSourceColumnIndex(board)),
                new IntegerCoordinate(kingActualRow,
                        actualKingCoordinate.getColumnIndex() +
                                classicCasteKingAssistantMoveDirection.getCurrentKingColumnIncrementer()));
    }
}
