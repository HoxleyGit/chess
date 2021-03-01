package com.company.engine.game.chess.rule.classic;

import com.company.commons.move.PlaneMove;

public class QueenClassicRule extends ClassicMoveRule {

    public QueenClassicRule(ClassicRuledPiece relatedPiece, ClassicRuledPiecesBoard board) {
        super(relatedPiece, board);
    }

    @Override
    public boolean test(PlaneMove move) {
        return super.test(move) &&
                new BishopClassicRule(relatedPiece, board).test(move) ||
                new RookClassicRule(relatedPiece, board).test(move);
    }
}
