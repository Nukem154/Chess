package edu.nukem;

import edu.nukem.pieces.*;

public class Chessboard {
    private final int ROWS = 8;
    private final int COLS = 8;
    private final Piece[][] board;

    public Chessboard() {
        board = new Piece[ROWS][COLS];
        // Initialize the board with pieces in their starting positions
        initializeBoard();
    }

    public void initializeBoard() {
        // Set up white pieces
        board[0][0] = new Rook(true);
        board[0][1] = new Knight(true);
        board[0][2] = new Bishop(true);
        board[0][3] = new Queen(true);
        board[0][4] = new King(true);
        board[0][5] = new Bishop(true);
        board[0][6] = new Knight(true);
        board[0][7] = new Rook(true);
        for (int col = 0; col < COLS; col++) {
            board[1][col] = new Pawn(true);
        }

        // Set up black pieces
        board[7][0] = new Rook(false);
        board[7][1] = new Knight(false);
        board[7][2] = new Bishop(false);
        board[7][3] = new Queen(false);
        board[7][4] = new King(false);
        board[7][5] = new Bishop(false);
        board[7][6] = new Knight(false);
        board[7][7] = new Rook(false);
        for (int col = 0; col < COLS; col++) {
            board[6][col] = new Pawn(false);
        }
    }

    public Piece getPiece(int row, int col) {
        return board[row][col];
    }

    public void setPiece(int row, int col, Piece piece) {
        board[row][col] = piece;
    }
}
