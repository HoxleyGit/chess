package com.company.engine.game.chess.pieces;

import com.company.engine.game.chess.chessboard.ClassicChessboard;
import com.company.engine.game.chess.game.GameState;
import com.company.engine.game.chess.rule.classic.ClassicRuledPiecesBoard;
import com.company.engine.game.chess.rule.classic.QueenClassicRule;
import com.company.engine.game.chess.pieces.attack.classic.QueenClassicAttackedCoordinatesFunction;
import com.company.engine.game.validation.rule.MoveRuledPiece;

public class Queen extends ClassicPiece {

    public Queen(boolean white, ClassicRuledPiecesBoard board) {
        this.white = white;
        this.moveRule = new QueenClassicRule(this, board);
        this.attackedCoordinatesFunction = new QueenClassicAttackedCoordinatesFunction(this, board);
    }

    @Override
    public String toString() {
        return "\u2655";
    }
}
