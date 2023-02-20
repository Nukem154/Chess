package edu.nukem.pieces;

import edu.nukem.Chessboard;

public class King extends Piece {
    public King(boolean isWhite) {
        super(isWhite);
    }

    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, Chessboard board) {
        // Check if the move is one square in any direction
        int rowDiff = Math.abs(toRow - fromRow);
        int colDiff = Math.abs(toCol - fromCol);
        if (rowDiff <= 1 && colDiff <= 1) {
            // Check if the destination square is empty or occupied by an opponent's piece
            Piece destPiece = board.getPiece(toRow, toCol);
            return destPiece == null || destPiece.isWhite() != isWhite();
        } else {
            return false;
        }
    }

    @Override
    public String getSymbol() {
        return isWhite() ? "K" : "k";
    }
}
