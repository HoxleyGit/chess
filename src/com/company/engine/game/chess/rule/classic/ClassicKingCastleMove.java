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

    private final ClassicRuledPiece relatedPiece;

    public ClassicKingCastleMove(ClassicRuledPiecesBoard board,
                                 PieceAtCoordinateMovedPredicate pieceAtCoordinateMovedPredicate,
                                 ClassicRuledPiece relatedPiece) {
        this.board = board;
        this.pieceAtCoordinateMovedPredicate = pieceAtCoordinateMovedPredicate;
        this.relatedPiece = relatedPiece;
    }

    @Override
    public boolean test(PlaneMove move) {
        return kingWillNotBeCheckOnMovePath(move) &&
                (new ClassicKingLeftCastleMove(board, pieceAtCoordinateMovedPredicate).test(move) ||
                new ClassicKingRightCastleMove(board, pieceAtCoordinateMovedPredicate).test(move));
    }

    private boolean kingWillNotBeCheckOnMovePath(PlaneMove move) {
        return board.getAllPieces().stream()
                .filter(piece -> piece.isWhite() != relatedPiece.isWhite())
                .flatMap(piece -> piece.getAttackedCoordinates(board).stream())
                .noneMatch(move.getCoordinatesBetweenStraight()::contains);
    }
}
