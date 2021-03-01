package com.company.engine.game.chess.rule.classic;

import com.company.commons.move.IntegerCoordinate;
import com.company.commons.move.PlaneMove;
import com.company.engine.game.validation.rule.MoveRule;

import java.util.Set;
import java.util.stream.Collectors;

public abstract class ClassicMoveRule implements MoveRule {

    protected final ClassicRuledPiece relatedPiece;

    protected final ClassicRuledPiecesBoard board;

    public ClassicMoveRule(ClassicRuledPiece relatedPiece, ClassicRuledPiecesBoard board) {
        this.relatedPiece = relatedPiece;
        this.board = board;
    }

    @Override
    public boolean test(PlaneMove move) {
        return currentKingMoveWillNotBeChecked(move);
    }

    private boolean currentKingMoveWillNotBeChecked(PlaneMove move) {
        return this.board.getAllPieces().stream()
                .filter(piece -> piece.isWhite() != relatedPiece.isWhite())
                .flatMap(piece -> piece.getAttackedCoordinates().stream())
                .noneMatch(getCurrentMovePredicatedCheckableCoordinates(move)::contains);
    }

    private Set<IntegerCoordinate> getCurrentMovePredicatedCheckableCoordinates(PlaneMove move) {
        var chessboardAfterMove = this.board.copyOf();
        chessboardAfterMove.move(move);
        return chessboardAfterMove.getOccupiedCoordinates().stream()
                .filter(coordinate -> {
                    var piece = chessboardAfterMove.getPiece(coordinate).orElseThrow();
                    return piece.isWhite() == relatedPiece.isWhite() && piece.isCheckable();
                })
                .collect(Collectors.toSet());
    }
}
