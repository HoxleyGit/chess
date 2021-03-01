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

    protected final AttackingPiecesBoard board;

    public AttackedCoordinatesFunction(ClassicRuledPiece relatedPiece, AttackingPiecesBoard board) {
        this.relatedPiece = relatedPiece;
        this.board = board;
    }

    @Override
    public Set<IntegerCoordinate> get() {
        return getRelatedPieceCoordinate()
                .map(this::getAttackedCoordinatesByRelatedPieceCoordinate)
                .orElse(new HashSet<>())
                .stream()
                .filter(board::isCoordinateFound)
                .collect(Collectors.toSet());
    }

    private Optional<IntegerCoordinate> getRelatedPieceCoordinate() {
        return board.getCoordinateOf(relatedPiece);
    }

    protected abstract Set<IntegerCoordinate> getAttackedCoordinatesByRelatedPieceCoordinate(
            IntegerCoordinate relatedPieceCoordinate);
}
