package com.company.commons.history;

import com.company.commons.move.PlaneMove;

import java.util.*;

public class MovesHistory<TPiece> {

    private final List<PlaneMove> moves = new ArrayList<>();

    private final Set<TPiece> movedPieces = new HashSet<>();

    public void addMove(PlaneMove move, TPiece movedPiece) {
        moves.add(move);
        movedPieces.add(movedPiece);
    }

    public boolean wasPieceMoved(TPiece piece) {
        return movedPieces.contains(piece);
    }
}