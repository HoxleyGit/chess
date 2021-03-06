package com.company.engine.game.chess.rule.classic;

import com.company.commons.history.MovesHistory;
import com.company.commons.move.PlaneMove;
import com.company.engine.game.MoveMadeObserver;
import com.company.engine.game.validation.rule.basic.PieceAtCoordinateMovedPredicate;

import static com.company.engine.game.chess.rule.classic.ClassicCasteKingAssistantMoveDirection.FROM_LEFT;
import static com.company.engine.game.chess.rule.classic.ClassicCasteKingAssistantMoveDirection.FROM_RIGHT;
import static com.company.engine.game.chess.rule.classic.KingAssistantMoveUtil.createKingAssistantCastleMove;

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
        classicRuledBoardMemoryMovesHistory.getLastMoveWithPreviousBoard().ifPresent(lastMoveWithPreviousBoard -> {
            var lastMove = lastMoveWithPreviousBoard.getMove();
            var previousBoard = lastMoveWithPreviousBoard.getPreviousBoard();
            var kingCoordinate = lastMove.getSource();
            PieceAtCoordinateMovedPredicate kingMovedPredicate =
                    coordinate -> previousBoard.getPiece(coordinate)
                            .map(piece -> lastMoveWithPreviousBoard.getPreviousMovesHistory().wasPieceMoved(piece)).orElse(false);
            PlaneMove kingAssistantCastleMove = null;
            if(!previousBoard.getPiece(lastMove.getSource()).map(ClassicRuledPiece::canCastle).orElse(false)) {
                return;
            }

            if(lastMove.isNStepRightStraightMove(2)) {
                kingAssistantCastleMove =
                        createKingAssistantCastleMove(kingCoordinate, FROM_RIGHT, board);

            } else if(lastMove.isNStepLeftStraightMove(2)) {
                kingAssistantCastleMove =
                        createKingAssistantCastleMove(kingCoordinate, FROM_LEFT, board);
            }

            if(kingAssistantCastleMove != null) {
                board.move(kingAssistantCastleMove);
                movesHistory.addMovedPiece(board.getPiece(kingAssistantCastleMove.getTarget()).orElseThrow());
            }
        });

    }
}
