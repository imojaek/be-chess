package chess;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import chess.pieces.Pawn;

public class BoardTest {

    Board board;

    @BeforeEach
    public void beforeEach() {
         board = new Board();
    }

    @Test
    @DisplayName("보드에 폰을 추가하고 확인할 수 있어야 한다.")
    public void create() throws Exception {
        Pawn white = new Pawn(Pawn.WHITE_COLOR);
        board.add(white, 0, 0);
        assertEquals(1, board.size());
        assertEquals(white, board.findPawn(0));

        Pawn black = new Pawn(Pawn.BLACK_COLOR);
        board.add(black, 1, 0);
        assertEquals(2, board.size());
        assertEquals(black, board.findPawn(1));
    }

    @Test
    @DisplayName("보드가 초기화되어 체스말들이 정상적으로 배치되어야 한다.")
    public void initialize() throws Exception {
        Board board = new Board();
        board.initialize();
        assertThat(board.size()).isEqualTo(16); // Feature3 현재, 흰색 검은색 폰이 각각 8개씩 생성되어 배치된다.
        assertEquals("♙♙♙♙♙♙♙♙", board.getWhitePawnsResult());
        assertEquals("♟♟♟♟♟♟♟♟", board.getBlackPawnsResult());
    }

    @Test
    @DisplayName("색상에 따라 구분된 리스트에 기물들이 들어가야 한다.")
    void classfyPiece() {
        board.add(new Pawn(Pawn.BLACK_COLOR), 0, 0);
        board.add(new Pawn(Pawn.BLACK_COLOR), 0, 1);
        board.add(new Pawn(Pawn.WHITE_COLOR), 0, 2);
        assertThat(board.getBlackPieces().size()).isEqualTo(2);
        assertThat(board.getWhitePieces().size()).isEqualTo(1);
    }


}
