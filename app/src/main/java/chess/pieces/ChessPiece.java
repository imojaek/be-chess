package chess.pieces;

public enum ChessPiece {
    WHITE_PAWN('♙'),
    WHITE_KNIGHT('♘'),
    WHITE_BISHOP('♗'),
    WHITE_ROOK('♖'),
    WHITE_QUEEN('♕'),
    WHITE_KING('♔'),
    BLACK_PAWN('♟'),
    BLACK_KNIGHT('♞'),
    BLACK_BISHOP('♝'),
    BLACK_ROOK('♜'),
    BLACK_QUEEN('♛'),
    BLACK_KING('♚'),
    NO_PIECE(' ');

    private final char chessIcon;

    ChessPiece(char chessIcon) {
        this.chessIcon = chessIcon;
    }

    public char getChessIcon() {
        return chessIcon;
    }
}

