package chess;

import chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private Pawn[][] board; // -> Piece[][]
    private static final int BOARD_X_MAX = 7;
    private static final int BOARD_Y_MAX = 7;
    private List<Pawn> pawnList;

    public Board() {
        this.board = new Pawn[8][8];
        pawnList = new ArrayList<>();
    }

    public void add(Pawn pawn, int xpos, int ypos) {
        board[xpos][ypos] = pawn;
        pawnList.add(pawn);
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

    public Pawn findPawn(int index) {
        return pawnList.get(index);
    }
}
