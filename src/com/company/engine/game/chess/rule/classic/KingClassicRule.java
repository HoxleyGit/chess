package com.company.engine.game.chess.rule.classic;

import com.company.commons.move.IntegerCoordinate;
import com.company.commons.move.PlaneMove;
import com.company.engine.game.validation.rule.basic.*;

import static com.company.engine.game.chess.rule.classic.ClassicCasteKingAssistantMoveDirection.FROM_LEFT;
import static com.company.engine.game.chess.rule.classic.ClassicCasteKingAssistantMoveDirection.FROM_RIGHT;

public class KingClassicRule extends ClassicMoveRule {

    private final PieceAtCoordinateMovedPredicate pieceAtCoordinateMovedPredicate;

    public KingClassicRule(ClassicRuledPiece relatedPiece,
                           ClassicRuledPiecesBoard board,
                           PieceAtCoordinateMovedPredicate pieceAtCoordinateMovedPredicate) {
        super(relatedPiece, board);
        this.pieceAtCoordinateMovedPredicate = pieceAtCoordinateMovedPredicate;
    }

    @Override
    public boolean test(PlaneMove move) {
        return super.test(move) && isSimpleKingMove(move) || isCastleMove(move);
    }

    private boolean isSimpleKingMove(PlaneMove move) {
        return move.isOneStepMove() &&
                new NoPieceFoundAtMoveTargetOrSoftCaptureMoveRule<>(relatedPiece, board).test(move);
    }

    private boolean isCastleMove(PlaneMove move) {
        var moveSource = move.getSource();
        return (move.isNStepLeftStraightMove(2) && canKingAssistantCastle(moveSource, FROM_RIGHT))
                || (move.isNStepRightStraightMove(2) && canKingAssistantCastle(moveSource, FROM_LEFT)) &&
                new OnlyFirstMoveRule(pieceAtCoordinateMovedPredicate).test(move) &&
                new NoPieceFoundAtMoveTargetRule<>(board).test(move) &&
                new NoPieceFoundAtCoordinatesRule<>(
                        board.getCoordinatesBetweenStraight(move), board).test(move);
    }

    private boolean canKingAssistantCastle(
            IntegerCoordinate actualKingCoordinate,
            ClassicCasteKingAssistantMoveDirection classicCasteKingAssistantMoveDirection) {
        var castleAssistantCastleMove =
                createKingAssistantCastleMove(actualKingCoordinate, classicCasteKingAssistantMoveDirection);
        return classicCasteKingAssistantMoveDirection.getKingAssistant(board, actualKingCoordinate.getRowIndex())
                .map(piece -> piece.getMoveRule().test(castleAssistantCastleMove) &&
                        new OnlyFirstMoveRule(pieceAtCoordinateMovedPredicate).test(castleAssistantCastleMove))
                .orElse(false);
    }

    private PlaneMove createKingAssistantCastleMove(
            IntegerCoordinate actualKingCoordinate,
            ClassicCasteKingAssistantMoveDirection classicCasteKingAssistantMoveDirection) {
        var kingActualRow = actualKingCoordinate.getRowIndex();
        return new PlaneMove(
                new IntegerCoordinate(kingActualRow,
                        classicCasteKingAssistantMoveDirection.getSourceColumnIndex(board)),
                new IntegerCoordinate(kingActualRow,
                        actualKingCoordinate.getColumnIndex() +
                                classicCasteKingAssistantMoveDirection.getCurrentKingColumnIncrementer()));
    }
}
