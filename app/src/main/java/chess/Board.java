package chess;

import chess.pieces.ChessPiece;
import chess.pieces.Piece;

import static chess.utils.StringUtils.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Board {
    private HashMap<String, Piece> chessBoard = new HashMap<>();
    private List<Piece> blackPieces = new ArrayList<>();
    private List<Piece> whitePieces = new ArrayList<>();
    private static final String BLACK_PAWN_RANK = "7";
    private static final String WHITE_PAWN_RANK = "2";

    public void add(Piece pawn, String position) {
        chessBoard.put(position, pawn);
        classifyPawn(pawn);
    }

    private void classifyPawn(Piece pawn) {
        if (pawn.getColor().equals(Piece.BLACK_COLOR))
            blackPieces.add(pawn);
        else if (pawn.getColor().equals(Piece.WHITE_COLOR))
            whitePieces.add(pawn);
    }

    public void start() {
        initialize();
        System.out.println(showBoard());
    }

    public void initialize() {
        initWhite();
        initBlack();
    }

    private void initWhite() {
        initWhiteMinorAndMajorPieces();
        initWhitePawn();
    }

    private void initBlack() {
        initBlackMinorAndMajorPieces();
        initBlackPawn();
    }

    private void initWhitePawn() {
        for (char file = 'A'; file <= 'H'; file++) {
            add(Piece.createNewPiece(Piece.WHITE_COLOR, ChessPiece.PAWN), file + WHITE_PAWN_RANK);
        }
    }
    private void initBlackPawn() {
        for (char file = 'A'; file <= 'H'; file++) {
            add(Piece.createNewPiece(Piece.BLACK_COLOR, ChessPiece.PAWN), file + BLACK_PAWN_RANK);
        }
    }

    private void initWhiteMinorAndMajorPieces() {
        List<ChessPiece> pieces = List.of(ChessPiece.ROOK, ChessPiece.KNIGHT, ChessPiece.BISHOP, ChessPiece.QUEEN,
                                            ChessPiece.KING, ChessPiece.BISHOP, ChessPiece.KNIGHT, ChessPiece.ROOK);
        List<String> position = List.of("A1", "B1", "C1", "D1", "E1", "F1", "G1", "H1");

        for (int i = 0; i < pieces.size(); i++) {
            add(Piece.createNewPiece(Piece.WHITE_COLOR, pieces.get(i)), position.get(i));
        }
    }

    private void initBlackMinorAndMajorPieces() {
        List<ChessPiece> pieces = List.of(ChessPiece.ROOK, ChessPiece.KNIGHT, ChessPiece.BISHOP, ChessPiece.QUEEN,
                                            ChessPiece.KING, ChessPiece.BISHOP, ChessPiece.KNIGHT, ChessPiece.ROOK);
        List<String> position = List.of("A8", "B8", "C8", "D8", "E8", "F8", "G8", "H8");

        for (int i = 0; i < pieces.size(); i++) {
            add(Piece.createNewPiece(Piece.BLACK_COLOR, pieces.get(i)), position.get(i));
        }
    }

    public int pieceCount() {
        return chessBoard.size();
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (int rank = 8; rank >= 1; rank--) { // 보드의 가장 윗줄인 8랭크부터 출력해야한다.
            sb.append(getLineByRank(rank));
            sb.append(appendNewLine(""));
        }
        return sb.toString();
    }

    private String getLineByRank(int rank) {
        StringBuilder sb = new StringBuilder();
        for (char file = 'A'; file <= 'H'; file++) {
            String targetPos = String.valueOf(file) + rank;
            if (chessBoard.containsKey(targetPos)) // 삼항연산자로 바꿔볼까 했으나, 너무 길어져 오히려 읽기 힘들었습니다.
                sb.append(chessBoard.get(targetPos).getChessIcon());
            else
                sb.append(ChessPiece.NO_PIECE.getWhiteChessIcon());
        }
        return sb.toString();
    }

    public List<Piece> getBlackPieces() {
        return blackPieces;
    }

    public List<Piece> getWhitePieces() {
        return whitePieces;
    }

    public String getWhitePawnsResult() {
        StringBuilder sb = new StringBuilder();
        for (Piece whitePiece : whitePieces) {
            sb.append(whitePiece.getChessIcon());
        }
        return sb.toString();
    }

    public String getBlackPawnsResult() {
        StringBuilder sb = new StringBuilder();
        for (Piece blackPiece : blackPieces) {
            sb.append(blackPiece.getChessIcon());
        }
        return sb.toString();
    }
}
