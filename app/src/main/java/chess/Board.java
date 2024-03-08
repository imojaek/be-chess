package chess;

import chess.pieces.Piece;
import chess.pieces.Piece.*;

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
        if (pawn.isSameColor(Color.BLACK))
            blackPieces.add(pawn);
        else if (pawn.isSameColor(Color.WHITE))
            whitePieces.add(pawn);
    }

    public void start() {
        initialize();
        System.out.println(showBoard());
    }

    public void initialize() {
        initWhite();
        initBlack();

        initBlank();
    }

    private void initWhite() {
        initWhiteMinorAndMajorPieces();
        initWhitePawn();
    }

    private void initBlack() {
        initBlackMinorAndMajorPieces();
        initBlackPawn();
    }

    private void initBlank() {
        for (int rank = 3; rank <= 6; rank++) {
            for (char file = 'A'; file <= 'H'; file++) {
                add(Piece.createNewPiece(Color.NOCOLOR, Type.NO_PIECE), file + String.valueOf(rank));
            }
        }
    }

    private void initWhitePawn() {
        for (char file = 'A'; file <= 'H'; file++) {
            add(Piece.createNewPiece(Color.WHITE, Type.PAWN), file + WHITE_PAWN_RANK);
        }
    }
    private void initBlackPawn() {
        for (char file = 'A'; file <= 'H'; file++) {
            add(Piece.createNewPiece(Color.BLACK, Type.PAWN), file + BLACK_PAWN_RANK);
        }
    }

    private void initWhiteMinorAndMajorPieces() {
        List<Type> pieces = List.of(Type.ROOK, Type.KNIGHT, Type.BISHOP, Type.QUEEN,
                Type.KING, Type.BISHOP, Type.KNIGHT, Type.ROOK);
        List<String> position = List.of("A1", "B1", "C1", "D1", "E1", "F1", "G1", "H1");

        for (int i = 0; i < pieces.size(); i++) {
            add(Piece.createNewPiece(Color.WHITE, pieces.get(i)), position.get(i));
        }
    }

    private void initBlackMinorAndMajorPieces() {
        List<Type> pieces = List.of(Type.ROOK, Type.KNIGHT, Type.BISHOP, Type.QUEEN,
                Type.KING, Type.BISHOP, Type.KNIGHT, Type.ROOK);
        List<String> position = List.of("A8", "B8", "C8", "D8", "E8", "F8", "G8", "H8");

        for (int i = 0; i < pieces.size(); i++) {
            add(Piece.createNewPiece(Color.BLACK, pieces.get(i)), position.get(i));
        }
    }

    public int pieceCount() {
        return chessBoard.size();
    }

    public int pieceCount(Color color, Type type) {
        if (color.equals(Color.WHITE)) {
            return countWhitePieceByType(type);
        }
        else if (color.equals(Color.BLACK)) {
            return countBlackPieceByType(type);
        }
        return 0; // 예외처리?
    }

    private int countWhitePieceByType(Type type) {
        int count = 0;
        for (Piece piece : whitePieces) {
            if (piece.isSameType(type))
                count++;
        }
        return count;
    }

    private int countBlackPieceByType(Type type) {
        int count = 0;
        for (Piece piece : blackPieces) {
            if (piece.isSameType(type))
                count++;
        }
        return count;
    }

    // TODO:  추후 사용자의 입력을 받을 경우, UpperCase 처리를 해야한다.
    public Piece findPiece(String position) {
        return chessBoard.get(position);
    }


    public void move(String position, Piece piece) {
        if (chessBoard.containsKey(position.toUpperCase())) {
            chessBoard.remove(position.toUpperCase());
        }
        chessBoard.put(position.toUpperCase(), piece);
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
            sb.append(chessBoard.get(targetPos).getChessIcon());
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
