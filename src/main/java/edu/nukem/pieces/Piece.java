package edu.nukem.pieces;

import edu.nukem.Chessboard;

public abstract class Piece {
    private boolean isWhite;

    public Piece(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public abstract boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, Chessboard board);

    public abstract String getSymbol();
}
