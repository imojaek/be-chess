package chess;

public class Pawn {

    private static final String WHITE = "white";
    private static final String BLACK = "black";

    private String color;

    public Pawn() {
        this(WHITE);
    }

    public Pawn(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
