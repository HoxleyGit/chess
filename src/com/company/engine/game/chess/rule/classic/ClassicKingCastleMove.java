package com.company.engine.game.chess.rule.classic;

import com.company.commons.move.IntegerCoordinate;
import com.company.commons.move.PlaneMove;
import com.company.engine.game.validation.rule.MoveRule;
import com.company.engine.game.validation.rule.basic.NoPieceFoundAtCoordinatesRule;
import com.company.engine.game.validation.rule.basic.NoPieceFoundAtMoveTargetRule;
import com.company.engine.game.validation.rule.basic.OnlyFirstMoveRule;
import com.company.engine.game.validation.rule.basic.PieceAtCoordinateMovedPredicate;

import static com.company.engine.game.chess.rule.classic.ClassicCasteKingAssistantMoveDirection.FROM_LEFT;
import static com.company.engine.game.chess.rule.classic.ClassicCasteKingAssistantMoveDirection.FROM_RIGHT;

public class ClassicKingCastleMove implements MoveRule {

    protected final ClassicRuledPiecesBoard board;

    private final PieceAtCoordinateMovedPredicate pieceAtCoordinateMovedPredicate;

    public ClassicKingCastleMove(ClassicRuledPiecesBoard board,
                                 PieceAtCoordinateMovedPredicate pieceAtCoordinateMovedPredicate) {
        this.board = board;
        this.pieceAtCoordinateMovedPredicate = pieceAtCoordinateMovedPredicate;
    }

    @Override
    public boolean test(PlaneMove move) {
        return new ClassicKingLeftCastleMove(board, pieceAtCoordinateMovedPredicate).test(move) ||
                new ClassicKingRightCastleMove(board, pieceAtCoordinateMovedPredicate).test(move);
    }
}
