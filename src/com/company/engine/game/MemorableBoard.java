package com.company.engine.game;

import com.company.commons.history.MovesHistory;
import com.company.commons.move.PlaneMove;
import com.company.engine.game.chess.rule.classic.ClassicRuledBoardMemoryMovesHistory;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiece;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiecesBoard;

public class MemorableBoard implements Board {

    private final ClassicRuledPiecesBoard board;

    private final ClassicRuledBoardMemoryMovesHistory classicRuledBoardMemoryMovesHistory;

    private final MovesHistory<ClassicRuledPiece> movesHistory;

    public MemorableBoard(ClassicRuledPiecesBoard board,
                          ClassicRuledBoardMemoryMovesHistory classicRuledBoardMemoryMovesHistory,
                          MovesHistory<ClassicRuledPiece> movesHistory) {
        this.board = board;
        this.classicRuledBoardMemoryMovesHistory = classicRuledBoardMemoryMovesHistory;
        this.movesHistory = movesHistory;
    }

    @Override
    public void move(PlaneMove move) {
        classicRuledBoardMemoryMovesHistory.addMove(move, board.copyOf(), movesHistory.copyOf());
        board.move(move);
    }

    @Override
    public String toString() {
        return board.toString();
    }
}
