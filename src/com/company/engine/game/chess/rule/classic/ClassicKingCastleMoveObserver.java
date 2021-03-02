/*
package com.company.engine.game.chess.rule.classic;

import com.company.commons.history.MovesHistory;
import com.company.commons.move.PlaneMove;
import com.company.engine.game.MoveMadeObserver;
import com.company.engine.game.validation.rule.basic.PieceAtCoordinateMovedPredicate;

import java.util.function.Supplier;

public class ClassicKingCastleMoveObserver implements MoveMadeObserver {

    private final ClassicRuledPiecesBoard board;

    private final MovesHistory<ClassicRuledPiece> movesHistory;

    private final ClassicRuledBoardMemoryMovesHistory classicRuledBoardMemoryMovesHistory;

    public ClassicKingCastleMoveObserver(
            ClassicRuledPiecesBoard board,
            MovesHistory<ClassicRuledPiece> movesHistory,
            ClassicRuledBoardMemoryMovesHistory classicRuledBoardMemoryMovesHistory) {
        this.board = board;
        this.movesHistory = movesHistory;
        this.classicRuledBoardMemoryMovesHistory = classicRuledBoardMemoryMovesHistory;
    }

    @Override
    public void onMoveMade() {
*/
/*        classicRuledBoardMemoryMovesHistory.getLastMoveWithPreviousBoard().ifPresent(lastMoveWithPreviousBoard -> {
            var lastMove = lastMoveWithPreviousBoard.getMove();
            var previousBoard = lastMoveWithPreviousBoard.getPreviousBoard();
            if(new ClassicKingCastleMove(
                    previousBoard,
                    coordinate -> previousBoard.getPiece(coordinate)
                            .map(piece -> lastMoveWithPreviousBoard.getPreviousMovesHistory().wasPieceMoved(piece)).orElse(false)).test(lastMove)) {
                board.move();
                movesHistory.addMovedPiece();
            }
        });*//*

    }
}
*/
