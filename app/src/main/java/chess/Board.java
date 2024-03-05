package chess;

import chess.pieces.ChessPiece;
import chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private Pawn[][] board = new Pawn[8][8]; // -> Piece[][]
    private static final int BOARD_X_MAX = 7;
    private static final int BOARD_Y_MAX = 7;
    private List<Pawn> pawnList = new ArrayList<>();
    private List<Pawn> blackPieces = new ArrayList<>();
    private List<Pawn> whitePieces = new ArrayList<>();

    public void add(Pawn pawn, int xpos, int ypos) {
        board[xpos][ypos] = pawn;
        pawnList.add(pawn);
        classifyPawn(pawn);
    }

    private void classifyPawn(Pawn pawn) {
        if (pawn.getColor().equals(Pawn.BLACK_COLOR))
            blackPieces.add(pawn);
        else if (pawn.getColor().equals(Pawn.WHITE_COLOR))
            whitePieces.add(pawn);
    }

    public void initialize() {
        initPawn();
    }

    private void initPawn() {
        for (int i = 0; i <= BOARD_X_MAX; i++) {
            add(new Pawn(Pawn.WHITE_COLOR), i, BOARD_Y_MAX - 1);
            add(new Pawn(Pawn.BLACK_COLOR), i, 0 + 1);
        }
    }

    public int size() {
        int boardSize = 0;
        for (int x = 0; x <= BOARD_X_MAX; x++) {
            for (int y = 0; y < BOARD_Y_MAX; y++) {
                if (board[x][y] != null)
                    boardSize++;
            }
        }
        return boardSize;
    }


    public String print() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y <= BOARD_Y_MAX; y++) {
            for (int x = 0; x <= BOARD_X_MAX; x++) {
                if (board[x][y] != null)
                    sb.append(board[x][y].getChessIcon());
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
