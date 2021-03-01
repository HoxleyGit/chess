package com.company.engine.game.chess.rule.classic;

import java.util.Optional;

public enum ClassicCasteKingAssistantMoveDirection {
    FROM_LEFT {
        @Override
        public int getCurrentKingColumnIncrementer() {
            return 1;
        }

        @Override
        public int getSourceColumnIndex(ClassicRuledPiecesBoard board) {
            return board.getFirstColumnIndex();
        }

        @Override
        public Optional<ClassicRuledPiece> getKingAssistant(ClassicRuledPiecesBoard board, int actualKingRowIndex) {
            return board.getFirstPieceOfRow(actualKingRowIndex);
        }
    },
    FROM_RIGHT {
        @Override
        public int getCurrentKingColumnIncrementer() {
            return -1;
        }

        @Override
        public int getSourceColumnIndex(ClassicRuledPiecesBoard board) {
            return board.getLastColumnIndex();
        }

        @Override
        public Optional<ClassicRuledPiece> getKingAssistant(ClassicRuledPiecesBoard board, int actualKingRowIndex) {
            return board.getLastPieceOfRow(actualKingRowIndex);
        }
    };

    public abstract int getCurrentKingColumnIncrementer();

    public abstract int getSourceColumnIndex(ClassicRuledPiecesBoard board);

    public abstract Optional<ClassicRuledPiece> getKingAssistant(ClassicRuledPiecesBoard board, int actualKingRowIndex);
}
