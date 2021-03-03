package com.company.engine.game.chess.rule.classic;

import com.company.commons.move.IntegerCoordinate;
import com.company.commons.move.PlaneMove;
import com.company.engine.game.validation.rule.MoveRule;
import com.company.engine.game.validation.rule.basic.BasicRuledPiece;

import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public abstract class ClassicMoveRule implements MoveRule {

    protected final ClassicRuledPiece relatedPiece;

    protected final ClassicRuledPiecesBoard board;

    protected final Supplier<Integer> movesCountSupplier;

    public ClassicMoveRule(ClassicRuledPiece relatedPiece,
                           ClassicRuledPiecesBoard board,
                           Supplier<Integer> movesCountSupplier) {
        this.relatedPiece = relatedPiece;
        this.board = board;
        this.movesCountSupplier = movesCountSupplier;
    }

    @Override
    public boolean test(PlaneMove move) {
        return isCurrentPieceColorMove(move) && currentKingMoveWillNotBeChecked(move);
    }

    private boolean isCurrentPieceColorMove(PlaneMove move) {
        var movedPiece = board.getPiece(move.getSource());
        return movesCountSupplier.get() % 2 == 0 ?
                movedPiece.map(BasicRuledPiece::isWhite).orElse(false) :
                movedPiece.map(piece -> !piece.isWhite()).orElse(false);
    }

    private boolean currentKingMoveWillNotBeChecked(PlaneMove move) {
        var chessboardAfterMove = this.board.copyOf();
        chessboardAfterMove.move(move);
        return chessboardAfterMove.getAllPieces().stream()
                .filter(piece -> piece.isWhite() != relatedPiece.isWhite())
                .flatMap(piece -> piece.getAttackedCoordinates(chessboardAfterMove).stream())
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
