package edu.nukem.pieces;

import edu.nukem.Chessboard;

public class Rook extends Piece {
    public Rook(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, Chessboard board) {
        // Check if the move is horizontal or vertical
        if (fromRow != toRow && fromCol != toCol) {
            return false;
        }
        // Check if the path to the destination square is clear
        int rowStep = Integer.signum(toRow - fromRow);
        int colStep = Integer.signum(toCol - fromCol);
        int row = fromRow + rowStep;
        int col = fromCol + colStep;
        while (row != toRow || col != toCol) {
            Piece intermediatePiece = board.getPiece(row, col);
            if (intermediatePiece != null) {
                return false;
            }
            row += rowStep;
            col += colStep;
        }
        // Check if the destination square is empty or occupied by an opponent's piece
        Piece destPiece = board.getPiece(toRow, toCol);
        return destPiece == null || destPiece.isWhite() != isWhite();
    }

    @Override
    public String getSymbol() {
        return isWhite() ? "R" : "r";
    }
}
