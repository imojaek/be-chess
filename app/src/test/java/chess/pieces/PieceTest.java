package chess.pieces;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.EnumOptions;

import static org.assertj.core.api.Assertions.*;

public class PieceTest {

   private final String WHITE = "white";
   private final String BLACK = "black";

    @Test
    @DisplayName("기물이 정상적으로 생성되는지 확인한다.")
    public void create() {
        verifyPawnColor(WHITE, ChessPiece.PAWN);
        verifyPawnColor(BLACK, ChessPiece.PAWN);
    }

    @DisplayName("매개로 받은 기물이 생성되어야 한다.")
    private void verifyPawnColor(final String color, ChessPiece pieceType) {
        Piece pieceTest = Piece.createNewPiece(color, pieceType);
        assertThat(pieceTest.getColor()).isEqualTo(color);
        assertThat(pieceTest.getPieceType()).isEqualTo(pieceType);
    }

    @Test
    @DisplayName("색상에 따라 다른 체스아이콘이 부여되어야 한다.")
    void verifyIconByColor() {
        Piece whitePawn = Piece.createNewPiece(Piece.WHITE_COLOR, ChessPiece.PAWN);
        assertThat(whitePawn.getChessIcon()).isEqualTo(ChessPiece.PAWN.getWhiteChessIcon());
        Piece blackPawn = Piece.createNewPiece(Piece.BLACK_COLOR, ChessPiece.PAWN);
        assertThat(blackPawn.getChessIcon()).isEqualTo(ChessPiece.PAWN.getBlackChessIcon());
    }

    @Test
    @DisplayName("메소드 팩토리가 color, chessPiece 별로 정확한 기물을 생성해야 한다.")
    public void create_piece_factory() {
        Piece blackBishop = Piece.createNewPiece(Piece.BLACK_COLOR, ChessPiece.BISHOP);
        assertThat(blackBishop.getColor()).isEqualTo(Piece.BLACK_COLOR);
        assertThat(blackBishop.getChessIcon()).isEqualTo(ChessPiece.BISHOP.getBlackChessIcon());

        Piece whiteKnight = Piece.createNewPiece(Piece.WHITE_COLOR, ChessPiece.KNIGHT);
        assertThat(whiteKnight.getColor()).isEqualTo(Piece.WHITE_COLOR);
        assertThat(whiteKnight.getChessIcon()).isEqualTo(ChessPiece.KNIGHT.getWhiteChessIcon());
    }



    @Test
    @DisplayName("메소드별로 정확한 기물이 생성되어야 한다.")
    public void create_piece() {
        verifyPiece(Piece.createWhitePawn(), Piece.WHITE_COLOR, ChessPiece.PAWN.getWhiteChessIcon());
        verifyPiece(Piece.createBlackPawn(), Piece.BLACK_COLOR, ChessPiece.PAWN.getBlackChessIcon());
        verifyPiece(Piece.createWhiteKnight(), Piece.WHITE_COLOR, ChessPiece.KNIGHT.getWhiteChessIcon());
        verifyPiece(Piece.createBlackKnight(), Piece.BLACK_COLOR, ChessPiece.KNIGHT.getBlackChessIcon());
        verifyPiece(Piece.createWhiteBishop(), Piece.WHITE_COLOR, ChessPiece.BISHOP.getWhiteChessIcon());
        verifyPiece(Piece.createBlackBishop(), Piece.BLACK_COLOR, ChessPiece.BISHOP.getBlackChessIcon());
        verifyPiece(Piece.createWhiteRook(), Piece.WHITE_COLOR, ChessPiece.ROOK.getWhiteChessIcon());
        verifyPiece(Piece.createBlackRook(), Piece.BLACK_COLOR, ChessPiece.ROOK.getBlackChessIcon());
        verifyPiece(Piece.createWhiteQueen(), Piece.WHITE_COLOR, ChessPiece.QUEEN.getWhiteChessIcon());
        verifyPiece(Piece.createBlackQueen(), Piece.BLACK_COLOR, ChessPiece.QUEEN.getBlackChessIcon());
        verifyPiece(Piece.createWhiteKing(), Piece.WHITE_COLOR, ChessPiece.KING.getWhiteChessIcon());
        verifyPiece(Piece.createBlackKing(), Piece.BLACK_COLOR, ChessPiece.KING.getBlackChessIcon());
    }

    private void verifyPiece(final Piece piece, final String color, final char chessIcon) {
        assertThat(piece.getColor()).isEqualTo(color);
        assertThat(piece.getChessIcon()).isEqualTo(chessIcon);
    }

    @ParameterizedTest
    @EnumSource(ChessPiece.class)
    @DisplayName("팩토리 메소드로 `색상 * 기물종류 = 12종`의 기물이 정상적으로 생성되어야 한다.")
    public void create_piece_factory_12(ChessPiece pieceType) {
        if (!pieceType.equals(ChessPiece.NO_PIECE)) {
            verifyPiece(Piece.createNewPiece(Piece.WHITE_COLOR, pieceType), Piece.WHITE_COLOR, pieceType.getWhiteChessIcon());
            verifyPiece(Piece.createNewPiece(Piece.BLACK_COLOR, pieceType), Piece.BLACK_COLOR, pieceType.getBlackChessIcon());
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