package application;

import chess.ChessMacth;

public class Program {

	public static void main(String[] args) {

		ChessMacth chessMacth = new ChessMacth();
		UI.PrintBoard(chessMacth.getPieces());

	}
}
