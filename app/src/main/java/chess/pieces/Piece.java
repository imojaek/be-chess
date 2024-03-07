package chess.pieces;

public class Piece {

    public enum Color {
        WHITE, BLACK, NOCOLOR;
    }

    public enum Type {

        PAWN('♟', '♙'),
        ROOK('♜', '♖'),
        KNIGHT('♞', '♘'),
        BISHOP('♝','♗'),
        QUEEN('♛', '♕'),
        KING('♚', '♔'),
        NO_PIECE('◻', '◻');

        private final char blackRepresentation;
        private final char whiteRepresentation;

        Type(char blackRepresentation, char whiteRepresentation) {
            this.blackRepresentation = blackRepresentation;
            this.whiteRepresentation = whiteRepresentation;
        }

        public char getWhiteRepresentation() {
            return whiteRepresentation;
        }

        public char getBlackRepresentation() {
            return blackRepresentation;
        }
    }

    private final char chessIcon;
    private final Color color;
    private final Type pieceType;

    private Piece(Color color, Type pieceType) {
        this.color = color;
        this.pieceType = pieceType;
        this.chessIcon = setPieceChessIcon();
    }

    static public Piece createNewPiece(Color pieceColor, Type pieceType) {
        Piece piece = null;
        if (pieceColor.equals(Color.WHITE)) {
            switch (pieceType) {
                case PAWN:
                    piece = createWhitePawn();
                    break;
                case KING:
                    piece = createWhiteKing();
                    break;
                case QUEEN:
                    piece = createWhiteQueen();
                    break;
                case ROOK:
                    piece = createWhiteRook();
                    break;
                case BISHOP:
                    piece = createWhiteBishop();
                    break;
                case KNIGHT:
                    piece = createWhiteKnight();
                    break;
            }
        }
        else if (pieceColor.equals(Color.BLACK)) {
            switch (pieceType) {
                case PAWN:
                    piece = createBlackPawn();
                    break;
                case KING:
                    piece = createBlackKing();
                    break;
                case QUEEN:
                    piece = createBlackQueen();
                    break;
                case ROOK:
                    piece = createBlackRook();
                    break;
                case BISHOP:
                    piece = createBlackBishop();
                    break;
                case KNIGHT:
                    piece = createBlackKnight();
                    break;
            }
        }
        return piece;
    }

    public static Piece createBlackPawn() {
        return new Piece(Color.BLACK, Type.PAWN);
    }
    public static Piece createWhitePawn() {
        return new Piece(Color.WHITE, Type.PAWN);
    }
    public static Piece createBlackKing() {
        return new Piece(Color.BLACK, Type.KING);
    }
    public static Piece createWhiteKing() {
        return new Piece(Color.WHITE, Type.KING);
    }
    public static Piece createBlackQueen() {
        return new Piece(Color.BLACK, Type.QUEEN);
    }
    public static Piece createWhiteQueen() {
        return new Piece(Color.WHITE, Type.QUEEN);
    }
    public static Piece createBlackRook() {
        return new Piece(Color.BLACK, Type.ROOK);
    }
    public static Piece createWhiteRook() {
        return new Piece(Color.WHITE, Type.ROOK);
    }
    public static Piece createBlackBishop() {
        return new Piece(Color.BLACK, Type.BISHOP);
    }
    public static Piece createWhiteBishop() {
        return new Piece(Color.WHITE, Type.BISHOP);
    }
    public static Piece createBlackKnight() {
        return new Piece(Color.BLACK, Type.KNIGHT);
    }
    public static Piece createWhiteKnight() {
        return new Piece(Color.WHITE, Type.KNIGHT);
    }

    public static Piece createBlank() {
        return new Piece(Color.NOCOLOR, Type.NO_PIECE);
    }

    private char setPieceChessIcon() {
        if (color.equals(Color.WHITE))
            return pieceType.getWhiteRepresentation();
        else
            return pieceType.getBlackRepresentation();
    }

    public boolean isWhite() {
        return color.equals(Color.WHITE);
    }
    public boolean isBlack() {
        return color.equals(Color.BLACK);
    }

    public Color getColor() {
        return color;
    }

    public char getChessIcon() {
        return chessIcon;
    }

    public Type getPieceType() {
        return pieceType;
    }
}
