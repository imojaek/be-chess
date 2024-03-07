package chess.pieces;

import org.junit.jupiter.api.*;

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
}