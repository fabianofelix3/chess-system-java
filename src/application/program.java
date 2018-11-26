package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMacth;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ChessMacth chessMacth = new ChessMacth();
		List<ChessPiece> captured = new ArrayList<>();

		while (!chessMacth.getCheckMate()) {
			try {
				UI.clearScreen();
				UI.printMatch(chessMacth, captured);
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);
				boolean[][] possibleMoves = chessMacth.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMacth.getPieces(), possibleMoves);

				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(sc);

				ChessPiece capturedPiece = chessMacth.performChessMove(source, target);

				if (capturedPiece != null) {
					captured.add(capturedPiece);
				}
				if (chessMacth.getPromoted() != null) {
					System.out.print("Enter piece of promotion (B/N/R/Q):");
					String type = sc.nextLine();
					chessMacth.replacePromotedPiece(type);
				}
			} catch (ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
		UI.clearScreen();
		UI.printMatch(chessMacth, captured);
	}
}
