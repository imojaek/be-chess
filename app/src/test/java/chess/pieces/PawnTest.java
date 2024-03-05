package chess.pieces;

import chess.pieces.Pawn;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {

    @Test
    @DisplayName("폰이 정상적으로 생성되는지 확인한다.")
    public void create() {
        final String WHITE = "white";
        final String BLACK = "black";
        verifyPawnColor(WHITE);
        verifyPawnColor(BLACK);
    }

    @DisplayName("매개로 받은 색상의 폰이 생성되어야 한다.")
    private void verifyPawnColor(final String color) {
        Pawn pawnTest = new Pawn(color);
        assertThat(pawnTest.getColor()).isEqualTo(color);
    }

    @Test
    @DisplayName("기본생성자로 생성되는 폰이 WHITE 색상을 갖는지 확인한다.")
    public void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertEquals("white", pawn.getColor());
    }
}