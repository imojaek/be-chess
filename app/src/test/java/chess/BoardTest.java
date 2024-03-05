package chess;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import pieces.Pawn;

public class BoardTest {
    @Test
    public void create() throws Exception {
        Board board = new Board();

        Pawn white = new Pawn(Pawn.WHITE_COLOR);
        assertEquals(white.getColor(), "white");
        board.add(white);
        assertEquals(1, board.size());
//        assertEquals(white, board.findPawn(0));
//
        Pawn black = new Pawn(Pawn.BLACK_COLOR);
        board.add(black);
        assertEquals(2, board.size());
//        assertEquals(black, board.findPawn(1));
    }
}