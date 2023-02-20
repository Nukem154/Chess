package edu.nukem.pieces;

import edu.nukem.Chessboard;

public class Queen extends Piece {
    public Queen(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, Chessboard board) {
        // Check if the move is horizontal, vertical, or diagonal
        int rowDiff = Math.abs(toRow - fromRow);
        int colDiff = Math.abs(toCol - fromCol);
        if (rowDiff == 0 || colDiff == 0 || rowDiff == colDiff) {
            // Check if the path is clear
            int rowStep = Integer.compare(toRow, fromRow);
            int colStep = Integer.compare(toCol, fromCol);
            int currRow = fromRow + rowStep;
            int currCol = fromCol + colStep;
            while (currRow != toRow || currCol != toCol) {
                if (board.getPiece(currRow, currCol) != null) {
                    return false;
                }
                currRow += rowStep;
                currCol += colStep;
            }
            // Check if the destination square is empty or occupied by an opponent's piece
            Piece destPiece = board.getPiece(toRow, toCol);
            return destPiece == null || destPiece.isWhite() != isWhite();
        } else {
            return false;
        }
    }

    @Override
    public String getSymbol() {
        return isWhite() ? "Q" : "q";
    }
}
