package com.company.engine.game.chess.rule.classic;

import com.company.commons.history.MovesHistory;
import com.company.engine.game.MoveMadeObservable;
import com.company.engine.game.MoveMadeObserver;
import com.company.engine.game.chess.pieces.Queen;
import com.company.engine.game.validation.rule.basic.BasicRuledPiece;

import java.util.function.Function;
import java.util.function.Supplier;

public class ClassicSimplePromotionMoveObserver implements MoveMadeObserver {

    private final ClassicRuledPiecesBoard board;

    private final ClassicRuledBoardMemoryMovesHistory classicRuledBoardMemoryMovesHistory;

    private final Function<Boolean, Queen> queenSupplier;

    public ClassicSimplePromotionMoveObserver(
            ClassicRuledPiecesBoard board,
            ClassicRuledBoardMemoryMovesHistory classicRuledBoardMemoryMovesHistory,
            Function<Boolean, Queen> queenSupplier) {
        this.board = board;
        this.classicRuledBoardMemoryMovesHistory = classicRuledBoardMemoryMovesHistory;
        this.queenSupplier = queenSupplier;
    }

    @Override
    public void onMoveMade() {
        classicRuledBoardMemoryMovesHistory.getLastMoveWithPreviousBoard().ifPresent(moveWithPreviousBoard -> {
            var lastMove = moveWithPreviousBoard.getMove();
            var lastMovePiece = board.getPiece(lastMove.getTarget());
            if(lastMovePiece.map(ClassicRuledPiece::canBePromoted).orElse(false)){
                if(lastMovePiece.get().isWhite() && board.getFirstRowIndex() == lastMove.getTargetRowIndex() ||
                        !lastMovePiece.get().isWhite() && board.getLastRowIndex() == lastMove.getTargetRowIndex()) {
                    board.placePiece(queenSupplier.apply(lastMovePiece.get().isWhite()), lastMove.getTarget());
                }
            }
        });
    }
}
