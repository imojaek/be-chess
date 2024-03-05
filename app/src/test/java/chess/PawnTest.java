package chess;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
    public void create() {
        Pawn pawn = new Pawn("white");
        Pawn pawnBlack = new Pawn("black");
        assertThat(pawn.getColor()).isEqualTo("white");
        assertThat(pawnBlack.getColor()).isEqualTo("black");
    }
}