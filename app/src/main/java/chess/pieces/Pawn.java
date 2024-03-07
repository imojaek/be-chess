package chess.pieces;

public class Pawn {

    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    private final char chessIcon;

    private final String color;

    public Pawn() {
        this(WHITE_COLOR);
    }

    public Pawn(String color) {
        this.color = color;
        this.chessIcon = setIconByColor();
    }

    private char setIconByColor() {
        if (this.color.equals(WHITE_COLOR))
            return ChessPiece.WHITE_PAWN.getChessIcon();
        else
            return ChessPiece.BLACK_PAWN.getChessIcon();
    }

    public String getColor() {
        return color;
    }

    public char getChessIcon() {
        return chessIcon;
    }
}
