package edu.nukem.pieces;

import edu.nukem.Chessboard;

public class Pawn extends Piece {
    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, Chessboard board) {
        // Check if the destination square is in the same column as the starting square
        if (fromCol != toCol) {
            // Pawn can only move diagonally if capturing an opponent's piece
            Piece destPiece = board.getPiece(toRow, toCol);
            if (destPiece == null || destPiece.isWhite() == isWhite()) {
                return false;
            }
            // Check if the move is a diagonal capture
            int rowDiff = Math.abs(toRow - fromRow);
            if (rowDiff == 1) {
                return true;
            } else {
                return false;
            }
        } else {
            // Check if the move is a valid forward move
            int rowDiff = toRow - fromRow;
            if (isWhite()) {
                if (rowDiff == 1) {
                    Piece destPiece = board.getPiece(toRow, toCol);
                    return destPiece == null;
                } else if (rowDiff == 2 && fromRow == 1) {
                    Piece destPiece = board.getPiece(toRow, toCol);
                    Piece intermediatePiece = board.getPiece(fromRow + 1, fromCol);
                    return destPiece == null && intermediatePiece == null;
                } else {
                    return false;
                }
            } else {
                if (rowDiff == -1) {
                    Piece destPiece = board.getPiece(toRow, toCol);
                    return destPiece == null;
                } else if (rowDiff == -2 && fromRow == 6) {
                    Piece destPiece = board.getPiece(toRow, toCol);
                    Piece intermediatePiece = board.getPiece(fromRow - 1, fromCol);
                    return destPiece == null && intermediatePiece == null;
                } else {
                    return false;
                }
            }
        }
    }


    @Override
    public String getSymbol() {
        return isWhite() ? "P" : "p";
    }
}
