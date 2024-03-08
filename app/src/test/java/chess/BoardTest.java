package chess;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

import chess.pieces.Piece;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import javax.annotation.meta.TypeQualifier;

import static chess.utils.StringUtils.*;
import chess.pieces.Piece.*; // Color, Type;

import java.awt.Color;

public class BoardTest {

    Board board;

    @BeforeEach
    public void beforeEach() {
         board = new Board();
    }

    @Test
    @DisplayName("색상에 따라 구분된 리스트에 기물들이 들어가야 한다.")
    void classifyPiece() {
        board.add(Piece.createNewPiece(Piece.Color.WHITE, Piece.Type.PAWN), "A1");
        board.add(Piece.createNewPiece(Piece.Color.BLACK, Piece.Type.PAWN), "A2");
        board.add(Piece.createNewPiece(Piece.Color.BLACK, Piece.Type.PAWN), "A3");
        assertThat(board.getBlackPieces().size()).isEqualTo(2);
        assertThat(board.getWhitePieces().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("초기화된 보드가 정상적으로 출력되어야 한다.")
    void print_initialize() {
        board.initialize();
        System.out.println(board.showBoard());
    }

    @Test
    @DisplayName("초기화된 보드에는 32개의 말이 있어야 한다.")
    void size_initialize() {
        board.initialize();
        assertThat(board.pieceCount()).isEqualTo(32);
    }

    @Test
    @DisplayName("초기화된 보드가 체스의 초기상태로 정상적으로 출력되어야 한다.")
    public void create() throws Exception {
        board.initialize();
        assertThat(board.pieceCount()).isEqualTo(32);
        StringBuilder blankRankBuilder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            blankRankBuilder.append(Type.NO_PIECE.getBlackRepresentation());
        }
        String blankRank = appendNewLine(blankRankBuilder.toString());

        assertThat(board.showBoard()).isEqualTo(appendNewLine("♜♞♝♛♚♝♞♜") +
                                                        appendNewLine("♟♟♟♟♟♟♟♟") +
                                                        blankRank + blankRank + blankRank + blankRank +
                                                        appendNewLine("♙♙♙♙♙♙♙♙") +
                                                        appendNewLine("♖♘♗♕♔♗♘♖"));
    }

    @ParameterizedTest
    @CsvSource({
            "PAWN, 8",
            "KNIGHT, 2",
            "BISHOP, 2",
            "ROOK, 2",
            "KING, 1",
            "QUEEN, 1"})
    @DisplayName("기물의 색 및 종류에 따라 개수를 정확히 계산해야 한다.")
    void pieceCount(Type type, int expectedResult) {
        board.initialize();
        assertThat(board.pieceCount(Piece.Color.WHITE, type)).isEqualTo(expectedResult);
        assertThat(board.pieceCount(Piece.Color.BLACK, type)).isEqualTo(expectedResult);
    }
}
