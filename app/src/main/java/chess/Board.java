package chess;

import chess.pieces.ChessPiece;
import chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Board {
    private HashMap<String, Pawn> chessBoard = new HashMap<>();
    private List<Pawn> pawnList = new ArrayList<>();
    private List<Pawn> blackPieces = new ArrayList<>();
    private List<Pawn> whitePieces = new ArrayList<>();
    private static final String BLACK_PAWN_RANK = "7";
    private static final String WHITE_PAWN_RANK = "2";

    public void add(Pawn pawn, String position) {
        chessBoard.put(position, pawn);
        pawnList.add(pawn);
        classifyPawn(pawn);
    }

    private void classifyPawn(Pawn pawn) {
        if (pawn.getColor().equals(Pawn.BLACK_COLOR))
            blackPieces.add(pawn);
        else if (pawn.getColor().equals(Pawn.WHITE_COLOR))
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
            add(new Pawn(Pawn.WHITE_COLOR), file + WHITE_PAWN_RANK);
        }
    }

    private void initBlackPawn() {
        for (int file = 'A'; file <= 'H'; file++) {
            add(new Pawn(Pawn.BLACK_COLOR), file + BLACK_PAWN_RANK);
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
                    sb.append(ChessPiece.NO_PIECE.getChessIcon());
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public Pawn findPawn(int index) {
        return pawnList.get(index);
    }

    public List<Pawn> getBlackPieces() {
        return blackPieces;
    }

    public List<Pawn> getWhitePieces() {
        return whitePieces;
    }

    public String getWhitePawnsResult() {
        StringBuilder sb = new StringBuilder();
        for (Pawn whitePiece : whitePieces) {
            sb.append(whitePiece.getChessIcon());
        }
        return sb.toString();
    }

    public String getBlackPawnsResult() {
        StringBuilder sb = new StringBuilder();
        for (Pawn blackPiece : blackPieces) {
            sb.append(blackPiece.getChessIcon());
        }
        return sb.toString();
    }
}
