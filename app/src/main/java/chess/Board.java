package chess;

import chess.pieces.ChessPiece;
import chess.pieces.Piece;

import static chess.utils.StringUtils.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Board {
    private HashMap<String, Piece> chessBoard = new HashMap<>();
    private List<Piece> pawnList = new ArrayList<>();
    private List<Piece> blackPieces = new ArrayList<>();
    private List<Piece> whitePieces = new ArrayList<>();
    private static final String BLACK_PAWN_RANK = "7";
    private static final String WHITE_PAWN_RANK = "2";

    public void add(Piece pawn, String position) {
        chessBoard.put(position, pawn);
        pawnList.add(pawn);
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
        System.out.println(print());
    }

    public void initialize() {
        initPawn();
    }

    private void initPawn() {
        initWhitePawn();
        initBlackPawn();
    }

    private void initWhitePawn() {
        for (int file = 'A'; file <= 'H'; file++) {
            add(Piece.createNewPiece(Piece.WHITE_COLOR, ChessPiece.PAWN), file + WHITE_PAWN_RANK);
        }
    }

    private void initBlackPawn() {
        for (int file = 'A'; file <= 'H'; file++) {
            add(Piece.createNewPiece(Piece.BLACK_COLOR, ChessPiece.PAWN), file + BLACK_PAWN_RANK);
        }
    }

    public int size() {
        return chessBoard.size();
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        for (int rank = 8; rank >= 1; rank--) { // 보드의 가장 윗줄인 8랭크부터 출력해야한다.
            for (int file = 'A'; file <= 'H'; file++) {
                String targetPos = String.valueOf(file) + rank;
                if (chessBoard.containsKey(targetPos))
                    sb.append(chessBoard.get(targetPos).getChessIcon());
                else
                    sb.append(ChessPiece.NO_PIECE.getWhiteChessIcon());
            }
            sb.append(appendNewLine(""));
        }
        return sb.toString();
    }

    public Piece findPawn(int index) {
        return pawnList.get(index);
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
