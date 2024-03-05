package chess;

import pieces.Pawn;

public class Board {
    private Pawn[][] board;
    private int xpos = 0;
    private int ypos = 0;
    private static final int BOARD_X_MAX = 7;
    private static final int BOARD_Y_MAX = 7;

    public Board() {
        this.board = new Pawn[8][8];
    }

    public void add(Pawn pawn) {
        if (findFreeBoard())
            board[xpos][ypos] = pawn;
    }

    private boolean findFreeBoard() {
        while (board[xpos][ypos] != null) {
            if (xpos == BOARD_X_MAX) {
                xpos = 0;
                ypos++;
            }
            if (ypos == BOARD_Y_MAX + 1)
                return false;
            xpos++;
        }
        return true;
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
}
