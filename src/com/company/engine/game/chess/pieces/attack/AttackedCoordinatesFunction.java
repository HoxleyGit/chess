package com.company.engine.game.chess.pieces.attack;

import com.company.commons.move.IntegerCoordinate;
import com.company.commons.move.IntegerCoordinatesSupplier;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiece;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiecesBoard;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class AttackedCoordinatesFunction implements IntegerCoordinatesSupplier {

    protected final ClassicRuledPiece relatedPiece;

    public AttackedCoordinatesFunction(ClassicRuledPiece relatedPiece) {
        this.relatedPiece = relatedPiece;
    }

    @Override
    public Set<IntegerCoordinate> apply(ClassicRuledPiecesBoard board) {
        return getRelatedPieceCoordinate(board)
                .map(coordinate -> getAttackedCoordinatesByRelatedPieceCoordinate(coordinate, board))
                .orElse(new HashSet<>())
                .stream()
                .filter(board::isCoordinateFound)
                .collect(Collectors.toSet());
    }

    private Optional<IntegerCoordinate> getRelatedPieceCoordinate(ClassicRuledPiecesBoard board) {
        return board.getCoordinateOf(relatedPiece);
    }

    protected abstract Set<IntegerCoordinate> getAttackedCoordinatesByRelatedPieceCoordinate(
            IntegerCoordinate relatedPieceCoordinate, ClassicRuledPiecesBoard classicRuledPiecesBoard);
}
