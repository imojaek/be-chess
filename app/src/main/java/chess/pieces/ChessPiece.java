package chess.pieces;

public enum ChessPiece {
    PAWN('♟', '♙'),
    ROOK('♜', '♖'),
    KNIGHT('♞', '♘'),
    BISHOP('♝','♗'),
    QUEEN('♛', '♕'),
    KING('♚', '♔'),
    NO_PIECE('◻', '◻');

    private final char blackChessIcon;
    private final char whiteChessIcon;

    private ChessPiece(char blackChessIcon, char whiteChessIcon) {
        this.blackChessIcon = blackChessIcon;
        this.whiteChessIcon = whiteChessIcon;
    }

    public char getBlackChessIcon() {
        return blackChessIcon;
    }

    public char getWhiteChessIcon() {
        return whiteChessIcon;
    }
}
