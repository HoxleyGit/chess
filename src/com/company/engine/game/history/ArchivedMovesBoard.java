package com.company.engine.game.history;

import com.company.commons.history.MovesHistory;
import com.company.commons.move.PlaneMove;
import com.company.engine.game.Board;

public class ArchivedMovesBoard<TPiece> implements Board {

    private final Board board;

    private final PiecedBoard<TPiece> piecedBoard;

    private final MovesHistory<TPiece> movesHistory;

    public ArchivedMovesBoard(Board board, PiecedBoard<TPiece> piecedBoard, MovesHistory<TPiece> movesHistory) {
        this.board = board;
        this.piecedBoard = piecedBoard;
        this.movesHistory = movesHistory;
    }

    @Override
    public void move(PlaneMove move) {
        var movedPiece = piecedBoard.getPiece(move.getSource());
        board.move(move);
        movedPiece.ifPresent(piece -> movesHistory.addMove(move, piece));
    }

    @Override
    public String toString() {
        return board.toString();
    }
}
