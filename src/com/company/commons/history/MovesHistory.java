package com.company.commons.history;

import com.company.commons.move.PlaneMove;

import java.util.*;

public class MovesHistory<TPiece> {

    private final List<PlaneMove> moves;

    private final Set<TPiece> movedPieces;

    public MovesHistory() {
        this(new ArrayList<>(), new HashSet<>());
    }

    private MovesHistory(List<PlaneMove> moves, Set<TPiece> movedPieces) {
        this.moves = moves;
        this.movedPieces = movedPieces;
    }

    public void addMove(PlaneMove move, TPiece movedPiece) {
        moves.add(move);
        addMovedPiece(movedPiece);
    }

    public void addMovedPiece(TPiece movedPiece) {
        movedPieces.add(movedPiece);
    }

    public boolean wasPieceMoved(TPiece piece) {
        return movedPieces.contains(piece);
    }

    public int countMoves() {
        return moves.size();
    }

    public MovesHistory<TPiece> copyOf() {
        return new MovesHistory<>(new ArrayList<>(moves), new HashSet<>(movedPieces));
    }
}
