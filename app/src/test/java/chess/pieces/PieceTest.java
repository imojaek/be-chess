package chess.pieces;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.*;

import chess.pieces.Piece.*;

public class PieceTest {

   private final String WHITE = "white";
   private final String BLACK = "black";

    @Test
    @DisplayName("기물이 정상적으로 생성되는지 확인한다.")
    public void create() {
        verifyPawnColor(Color.WHITE, Type.PAWN);
        verifyPawnColor(Color.BLACK, Type.PAWN);
    }

    @DisplayName("매개로 받은 기물이 생성되어야 한다.")
    private void verifyPawnColor(final Color color, Type pieceType) {
        Piece pieceTest = Piece.createNewPiece(color, pieceType);
        assertThat(pieceTest.isSameColor(color)).isTrue();
        assertThat(pieceTest.isSameType(pieceType)).isTrue();
    }

    @Test
    @DisplayName("색상에 따라 다른 체스아이콘이 부여되어야 한다.")
    void verifyIconByColor() {
        Piece whitePawn = Piece.createNewPiece(Color.WHITE, Type.PAWN);
        assertThat(whitePawn.getChessIcon()).isEqualTo(Type.PAWN.getWhiteRepresentation());
        Piece blackPawn = Piece.createNewPiece(Color.BLACK, Type.PAWN);
        assertThat(blackPawn.getChessIcon()).isEqualTo(Type.PAWN.getBlackRepresentation());
    }

    @Test
    @DisplayName("메소드 팩토리가 color, chessPiece 별로 정확한 기물을 생성해야 한다.")
    public void create_piece_factory() {
        Piece blackBishop = Piece.createNewPiece(Color.BLACK, Type.BISHOP);
        assertThat(blackBishop.isSameColor(Color.BLACK)).isTrue();
        assertThat(blackBishop.getChessIcon()).isEqualTo(Type.BISHOP.getBlackRepresentation());

        Piece whiteKnight = Piece.createNewPiece(Color.WHITE, Type.KNIGHT);
        assertThat(whiteKnight.isSameColor(Color.WHITE)).isTrue();
        assertThat(whiteKnight.getChessIcon()).isEqualTo(Type.KNIGHT.getWhiteRepresentation());
    }

    @Test
    @DisplayName("메소드별로 정확한 기물이 생성되어야 한다.")
    public void create_piece() {
        verifyPiece(Piece.createWhitePawn(), Color.WHITE, Type.PAWN.getWhiteRepresentation());
        verifyPiece(Piece.createBlackPawn(), Color.BLACK, Type.PAWN.getBlackRepresentation());
        verifyPiece(Piece.createWhiteKnight(), Color.WHITE, Type.KNIGHT.getWhiteRepresentation());
        verifyPiece(Piece.createBlackKnight(), Color.BLACK, Type.KNIGHT.getBlackRepresentation());
        verifyPiece(Piece.createWhiteBishop(), Color.WHITE, Type.BISHOP.getWhiteRepresentation());
        verifyPiece(Piece.createBlackBishop(), Color.BLACK, Type.BISHOP.getBlackRepresentation());
        verifyPiece(Piece.createWhiteRook(), Color.WHITE, Type.ROOK.getWhiteRepresentation());
        verifyPiece(Piece.createBlackRook(), Color.BLACK, Type.ROOK.getBlackRepresentation());
        verifyPiece(Piece.createWhiteQueen(), Color.WHITE, Type.QUEEN.getWhiteRepresentation());
        verifyPiece(Piece.createBlackQueen(), Color.BLACK, Type.QUEEN.getBlackRepresentation());
        verifyPiece(Piece.createWhiteKing(), Color.WHITE, Type.KING.getWhiteRepresentation());
        verifyPiece(Piece.createBlackKing(), Color.BLACK, Type.KING.getBlackRepresentation());

        Piece blank = Piece.createBlank();
        assertThat(blank.isWhite()).isFalse();
        assertThat(blank.isBlack()).isFalse();
        assertThat(blank.isSameType(Type.NO_PIECE)).isTrue();
    }

    private void verifyPiece(final Piece piece, final Piece.Color color, final char chessIcon) {
        assertThat(piece.isSameColor(color)).isTrue();
        assertThat(piece.getChessIcon()).isEqualTo(chessIcon);
    }

    @ParameterizedTest
    @EnumSource(Type.class)
    @DisplayName("팩토리 메소드로 `색상 * 기물종류 = 12종`의 기물이 정상적으로 생성되어야 한다.")
    public void create_piece_factory_12(Type pieceType) {
        if (!pieceType.equals(Type.NO_PIECE)) {
            verifyPiece(Piece.createNewPiece(Color.WHITE, pieceType), Color.WHITE, pieceType.getWhiteRepresentation());
            verifyPiece(Piece.createNewPiece(Color.BLACK, pieceType), Color.BLACK, pieceType.getBlackRepresentation());
        }
    }

    @Test
    @DisplayName("현재 기물이 검은색인지 확인한다.")
    public void isBlack() {
        Piece blackPawn = Piece.createBlackPawn();
        assertThat(blackPawn.isBlack()).isTrue();

        Piece whitePawn = Piece.createWhitePawn();
        assertThat(whitePawn.isBlack()).isFalse();
    }

    @Test
    @DisplayName("현재 기물이 흰색인지 확인한다.")
    public void isWhite() {
        Piece blackKnight = Piece.createBlackKnight();
        assertThat(blackKnight.isWhite()).isFalse();

        Piece whiteKnight = Piece.createWhiteKnight();
        assertThat(whiteKnight.isWhite()).isTrue();
    }

}