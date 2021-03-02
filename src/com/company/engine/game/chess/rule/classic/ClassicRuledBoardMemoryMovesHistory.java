/*
package com.company.engine.game.chess.rule.classic;

import com.company.commons.history.MovesHistory;
import com.company.commons.move.PlaneMove;

import java.util.*;

public class ClassicRuledBoardMemoryMovesHistory  {

    private final List<MoveWithPreviousBoard> movesWithPreviousBoards = new ArrayList<>();

    public void addMove(PlaneMove move, ClassicRuledPiecesBoard board) {
        movesWithPreviousBoards.add(new MoveWithPreviousBoard(move, board));
    }

    public Optional<MoveWithPreviousBoard> getLastMoveWithPreviousBoard() {
        return movesWithPreviousBoards.stream().skip(movesWithPreviousBoards.size() - 1).findFirst();
    }

    public static class MoveWithPreviousBoard {

        private final PlaneMove move;

        private final ClassicRuledPiecesBoard previousBoard;

        private final MovesHistory<ClassicRuledPiece> previousMovesHistory;

        public MoveWithPreviousBoard(PlaneMove move,
                                     ClassicRuledPiecesBoard previousBoard,
                                     MovesHistory<ClassicRuledPiece> previousMovesHistory) {
            this.move = move;
            this.previousBoard = previousBoard;
            this.previousMovesHistory = previousMovesHistory;
        }

        public PlaneMove getMove() {
            return move;
        }

        public ClassicRuledPiecesBoard getPreviousBoard() {
            return previousBoard;
        }

        public MovesHistory<ClassicRuledPiece> getPreviousMovesHistory() {
            return previousMovesHistory;
        }
    }

}
*/
