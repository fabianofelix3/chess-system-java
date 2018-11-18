package application;

import chess.ChessMacth;

public class program {

	public static void main(String[] args) {

		ChessMacth chessMacth = new ChessMacth();
		UI.PrintBoard(chessMacth.getPieces());

	}
}
