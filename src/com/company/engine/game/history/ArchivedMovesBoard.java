package com.company.engine.game.history;

import com.company.commons.history.MovesHistory;
import com.company.commons.move.PlaneMove;
import com.company.engine.game.Board;

public class ArchivedMovesBoard<TPiece> implements Board {

    private final PiecedBoard<TPiece> board;

    private final MovesHistory<TPiece> movesHistory;

    public ArchivedMovesBoard(PiecedBoard<TPiece> board, MovesHistory<TPiece> movesHistory) {
        this.board = board;
        this.movesHistory = movesHistory;
    }

    @Override
    public void move(PlaneMove move) {
        var movedPiece = board.getPiece(move.getSource());
        board.move(move);
        movedPiece.ifPresent(piece -> movesHistory.addMove(move, piece));
    }

    @Override
    public String toString() {
        return board.toString();
    }
}
