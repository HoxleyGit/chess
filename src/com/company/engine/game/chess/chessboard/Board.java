package com.company.engine.game.chess.chessboard;

import com.company.engine.game.validation.rule.MoveRuledPiece;
import com.company.commons.move.IntegerCoordinate;
import com.company.commons.move.PlaneMove;

import java.util.Optional;

public interface Board {

    void move(PlaneMove move);

    Optional<MoveRuledPiece> getPiece(IntegerCoordinate point);
}
