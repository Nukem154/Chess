package edu.nukem;

import edu.nukem.pieces.Piece;

import java.util.Scanner;

public class Game {
    private final Chessboard board;
    private boolean isWhiteTurn;

    public static void main(String[] args) {
        new Game().start();
    }

    public Game() {
        board = new Chessboard();
        isWhiteTurn = true;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // Print the board
            printBoard();

            // Get the player's move
            System.out.println((isWhiteTurn ? "White" : "Black") + " to move.");
            System.out.print("Enter move (e.g. e2 e4): ");
            String input = scanner.nextLine();
            String[] tokens = input.split(" ");
            int fromRow = 8 - Integer.parseInt(tokens[0].substring(1));
            int fromCol = tokens[0].charAt(0) - 'a';
            int toRow = 8 - Integer.parseInt(tokens[1].substring(1));
            int toCol = tokens[1].charAt(0) - 'a';

            // Check if the move is valid
            Piece piece = board.getPiece(fromRow, fromCol);
            if (piece == null || piece.isWhite() != isWhiteTurn || !piece.isValidMove(fromRow, fromCol, toRow, toCol, board)) {
                System.out.println("Invalid move. Please try again.");
                continue;
            }

            // Move the piece
            board.setPiece(toRow, toCol, piece);
            board.setPiece(fromRow, fromCol, null);

            // Switch turns
            isWhiteTurn = !isWhiteTurn;
        }
    }

    public void printBoard() {
        System.out.println("   a b c d e f g h");
        System.out.println("  +-----------------+");
        for (int row = 0; row < 8; row++) {
            System.out.print((8 - row) + " |");
            for (int col = 0; col < 8; col++) {
                Piece piece = board.getPiece(row, col);
                if (piece == null) {
                    System.out.print("  ");
                } else {
                    System.out.print(piece.getSymbol() + " ");
                }
            }
            System.out.println("| " + (8 - row));
        }
        System.out.println("  +-----------------+");
        System.out.println("   a b c d e f g h");
    }
}