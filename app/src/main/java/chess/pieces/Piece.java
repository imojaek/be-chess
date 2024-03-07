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
        return new Piece(color, pieceType);
    }

    private char setPieceChessIcon() {
        if (color.equals(WHITE_COLOR))
            return pieceType.getWhiteChessIcon();
        else
            return pieceType.getBlackChessIcon();
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
