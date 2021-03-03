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
import static com.company.engine.game.chess.rule.classic.KingAssistantMoveUtil.createKingAssistantCastleMove;

public class ClassicKingCastleBaseMoveRule implements MoveRule {

    protected final ClassicRuledPiecesBoard board;

    protected final PieceAtCoordinateMovedPredicate pieceAtCoordinateMovedPredicate;

    public ClassicKingCastleBaseMoveRule(ClassicRuledPiecesBoard board,
                                 PieceAtCoordinateMovedPredicate pieceAtCoordinateMovedPredicate) {
        this.board = board;
        this.pieceAtCoordinateMovedPredicate = pieceAtCoordinateMovedPredicate;
    }

    @Override
    public boolean test(PlaneMove move) {
        return board.getPiece(move.getSource()).map(ClassicRuledPiece::canCastle).orElse(false) &&
                new OnlyFirstMoveRule(pieceAtCoordinateMovedPredicate).test(move) &&
                new NoPieceFoundAtMoveTargetRule<>(board).test(move) &&
                new NoPieceFoundAtCoordinatesRule<>(
                        board.getCoordinatesBetweenStraight(move), board).test(move);
    }

    protected boolean canKingAssistantCastle(
            IntegerCoordinate actualKingCoordinate,
            ClassicCasteKingAssistantMoveDirection classicCasteKingAssistantMoveDirection) {
        var castleAssistantCastleMove =
                createKingAssistantCastleMove(actualKingCoordinate, classicCasteKingAssistantMoveDirection, board);
        return classicCasteKingAssistantMoveDirection.getKingAssistant(board, actualKingCoordinate.getRowIndex())
                .map(piece -> piece.getMoveRule().test(castleAssistantCastleMove) &&
                        new OnlyFirstMoveRule(pieceAtCoordinateMovedPredicate).test(castleAssistantCastleMove))
                .orElse(false);
    }
}
