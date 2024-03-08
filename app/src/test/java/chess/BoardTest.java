package chess;

import chess.pieces.Piece;
import chess.pieces.Piece.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static chess.utils.StringUtils.appendNewLine;
import static org.assertj.core.api.Assertions.assertThat;

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
    @DisplayName("초기화된 보드에는 64개(32개의 빈칸 포함)의 Piece가 있어야 한다.")
    void size_initialize() {
        board.initialize();
        assertThat(board.pieceCount()).isEqualTo(64);
    }

    @Test
    @DisplayName("초기화된 보드가 체스의 초기상태로 정상적으로 출력되어야 한다.")
    public void create() throws Exception {
        board.initialize();
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

    @ParameterizedTest
    @MethodSource("provideTypeAndPositionWhenInit")
    @DisplayName("특정 좌표의 기물을 가져올 수 있어야 한다.")
    void findPiece(Type type, String position) {
        board.initialize();
        assertThat(board.findPiece(position).isSameType(type)).isTrue();
    }

    private static Stream<Arguments> provideTypeAndPositionWhenInit() {
        return Stream.of(
                Arguments.of("ROOK", "A1"),
                Arguments.of("KNIGHT", "B1"),
                Arguments.of("BISHOP", "C1"),
                Arguments.of("QUEEN", "D1"),
                Arguments.of("KING", "E1"),
                Arguments.of("BISHOP", "F1"),
                Arguments.of("KNIGHT", "G1"),
                Arguments.of("ROOK", "H1"),
                Arguments.of("PAWN", "A2"),
                Arguments.of("PAWN", "B2"),
                Arguments.of("PAWN", "C2"),
                Arguments.of("PAWN", "D2"),
                Arguments.of("PAWN", "E2"),
                Arguments.of("PAWN", "F2"),
                Arguments.of("PAWN", "G2"),
                Arguments.of("PAWN", "H2"),
                Arguments.of("NO_PIECE", "A3"),
                Arguments.of("NO_PIECE", "B3"),
                Arguments.of("NO_PIECE", "C3"),
                Arguments.of("NO_PIECE", "D3"),
                Arguments.of("NO_PIECE", "E3"),
                Arguments.of("NO_PIECE", "F3"),
                Arguments.of("NO_PIECE", "G3"),
                Arguments.of("NO_PIECE", "H3"),
                Arguments.of("NO_PIECE", "A4"),
                Arguments.of("NO_PIECE", "B4"),
                Arguments.of("NO_PIECE", "C4"),
                Arguments.of("NO_PIECE", "D4"),
                Arguments.of("NO_PIECE", "E4"),
                Arguments.of("NO_PIECE", "F4"),
                Arguments.of("NO_PIECE", "G4"),
                Arguments.of("NO_PIECE", "H4"),
                Arguments.of("NO_PIECE", "A5"),
                Arguments.of("NO_PIECE", "B5"),
                Arguments.of("NO_PIECE", "C5"),
                Arguments.of("NO_PIECE", "D5"),
                Arguments.of("NO_PIECE", "E5"),
                Arguments.of("NO_PIECE", "F5"),
                Arguments.of("NO_PIECE", "G5"),
                Arguments.of("NO_PIECE", "H5"),
                Arguments.of("NO_PIECE", "A6"),
                Arguments.of("NO_PIECE", "B6"),
                Arguments.of("NO_PIECE", "C6"),
                Arguments.of("NO_PIECE", "D6"),
                Arguments.of("NO_PIECE", "E6"),
                Arguments.of("NO_PIECE", "F6"),
                Arguments.of("NO_PIECE", "G6"),
                Arguments.of("NO_PIECE", "H6"),
                Arguments.of("PAWN", "A7"),
                Arguments.of("PAWN", "B7"),
                Arguments.of("PAWN", "C7"),
                Arguments.of("PAWN", "D7"),
                Arguments.of("PAWN", "E7"),
                Arguments.of("PAWN", "F7"),
                Arguments.of("PAWN", "G7"),
                Arguments.of("PAWN", "H7"),
                Arguments.of("ROOK", "A8"),
                Arguments.of("KNIGHT", "B8"),
                Arguments.of("BISHOP", "C8"),
                Arguments.of("QUEEN", "D8"),
                Arguments.of("KING", "E8"),
                Arguments.of("BISHOP", "F8"),
                Arguments.of("KNIGHT", "G8"),
                Arguments.of("ROOK", "H8")
        );
    }

    @Test
    @DisplayName("보드의 특정 좌표로 기물을 옮길 수 있어야 한다.")
    public void move() throws Exception {
        board.initializeEmpty();

        String position = "B5";
        Piece piece = Piece.createBlackRook();
        board.move(position, piece);

        assertThat(board.findPiece(position).isSamePiece(piece)).isTrue();
        System.out.println(board.showBoard());
    }

}
