package chess.pieces;

public class Piece {

    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    private final char chessIcon;
    private final String color;
    private final ChessPiece pieceType;

    private Piece(String color, ChessPiece pieceType) {
        this.color = color;
        this.pieceType = pieceType;
        this.chessIcon = setPieceChessIcon();
    }

    static public Piece createNewPiece(String color, ChessPiece pieceType) {
        Piece piece = null;
        if (color.equals(WHITE_COLOR)) {
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
        else if (color.equals(BLACK_COLOR)) {
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
        return new Piece(BLACK_COLOR, ChessPiece.PAWN);
    }
    public static Piece createWhitePawn() {
        return new Piece(WHITE_COLOR, ChessPiece.PAWN);
    }
    public static Piece createBlackKing() {
        return new Piece(BLACK_COLOR, ChessPiece.KING);
    }
    public static Piece createWhiteKing() {
        return new Piece(WHITE_COLOR, ChessPiece.KING);
    }
    public static Piece createBlackQueen() {
        return new Piece(BLACK_COLOR, ChessPiece.QUEEN);
    }
    public static Piece createWhiteQueen() {
        return new Piece(WHITE_COLOR, ChessPiece.QUEEN);
    }
    public static Piece createBlackRook() {
        return new Piece(BLACK_COLOR, ChessPiece.ROOK);
    }
    public static Piece createWhiteRook() {
        return new Piece(WHITE_COLOR, ChessPiece.ROOK);
    }
    public static Piece createBlackBishop() {
        return new Piece(BLACK_COLOR, ChessPiece.BISHOP);
    }
    public static Piece createWhiteBishop() {
        return new Piece(WHITE_COLOR, ChessPiece.BISHOP);
    }
    public static Piece createBlackKnight() {
        return new Piece(BLACK_COLOR, ChessPiece.KNIGHT);
    }
    public static Piece createWhiteKnight() {
        return new Piece(WHITE_COLOR, ChessPiece.KNIGHT);
    }

    private char setPieceChessIcon() {
        if (color.equals(WHITE_COLOR))
            return pieceType.getWhiteChessIcon();
        else
            return pieceType.getBlackChessIcon();
    }

    public boolean isWhite() {
        return color.equals(WHITE_COLOR);
    }
    public boolean isBlack() {
        return color.equals(BLACK_COLOR);
    }

    public String getColor() {
        return color;
    }

    public char getChessIcon() {
        return chessIcon;
    }

    public ChessPiece getPieceType() {
        return pieceType;
    }
}
