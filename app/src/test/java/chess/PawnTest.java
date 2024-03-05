package chess;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("폰이 정상적으로 생성되는지 확인한다.")
    public void create() {
        final String colorWhite = "white";
        final String colorBlack = "black";
        verifyPawnColor(colorWhite);
        verifyPawnColor(colorBlack);
    }

    @DisplayName("폰의 color가 잘 들어가는지 확인한다.")
    private void verifyPawnColor(final String color) {
        Pawn pawnTest = new Pawn(color);
        assertThat(pawnTest.getColor()).isEqualTo(color);
    }
}