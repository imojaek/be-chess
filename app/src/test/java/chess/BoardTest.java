package chess;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

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
        board.add(white, "B1");
        assertThat(board.size()).isEqualTo(1);
        assertThat(board.findPawn(0)).isEqualTo(white);

        Pawn black = new Pawn(Pawn.BLACK_COLOR);
        board.add(black, "G1");
        assertThat(board.size()).isEqualTo(2);
        assertThat(board.findPawn(1)).isEqualTo(black);
    }

    @Test
    @DisplayName("보드가 초기화되어 체스말들이 정상적으로 배치되어야 한다.")
    public void initialize() throws Exception {
        Board board = new Board();
        board.initialize();
        assertThat(board.size()).isEqualTo(16); // Feature3 현재, 흰색 검은색 폰이 각각 8개씩 생성되어 배치된다.
        assertThat(board.getWhitePawnsResult()).isEqualTo("♙♙♙♙♙♙♙♙");
        assertThat(board.getBlackPawnsResult()).isEqualTo("♟♟♟♟♟♟♟♟");
    }

    @Test
    @DisplayName("색상에 따라 구분된 리스트에 기물들이 들어가야 한다.")
    void classifyPiece() {
        board.add(new Pawn(Pawn.BLACK_COLOR), "A1");
        board.add(new Pawn(Pawn.BLACK_COLOR), "A2");
        board.add(new Pawn(Pawn.WHITE_COLOR), "A3");
        assertThat(board.getBlackPieces().size()).isEqualTo(2);
        assertThat(board.getWhitePieces().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("초기화된 보드가 정상적으로 출력되어야 한다.")
    void print_initialize() {
        board.initialize();
        System.out.println(board.print());
    }

}
