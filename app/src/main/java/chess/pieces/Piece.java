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

    private static Piece createWhite(Type type) {
        return new Piece(Color.WHITE, type);
    }
    private static Piece createBlack(Type type) {
        return new Piece(Color.BLACK, type);
    }

    public static Piece createBlackPawn() {
        return createBlack(Type.PAWN);
    }
    public static Piece createWhitePawn() {
        return createWhite(Type.PAWN);
    }
    public static Piece createBlackKnight() {
        return createBlack(Type.KNIGHT);
    }
    public static Piece createWhiteKnight() {
        return createWhite(Type.KNIGHT);
    }
    public static Piece createBlackBishop() {
        return createBlack(Type.BISHOP);
    }
    public static Piece createWhiteBishop() {
        return createWhite(Type.BISHOP);
    }
    public static Piece createBlackRook() {
        return createBlack(Type.ROOK);
    }
    public static Piece createWhiteRook() {
        return createWhite(Type.ROOK);
    }
    public static Piece createBlackQueen() {
        return createBlack(Type.QUEEN);
    }
    public static Piece createWhiteQueen() {
        return createWhite(Type.QUEEN);
    }
    public static Piece createBlackKing() {
        return createBlack(Type.KING);
    }
    public static Piece createWhiteKing() {
        return createWhite(Type.KING);
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

    public boolean isSameType(Type type) {
        return pieceType.equals(type);
    }

}
