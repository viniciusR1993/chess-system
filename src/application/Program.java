package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		
		while(true) {
			try {
				UI.clearScreen();	//Limpa a tela
				UI.printBoard(chessMatch.getPieces());	//Imprime o tabuleiro	
				System.out.println();
				System.out.println("Source: ");
				ChessPosition source = UI.readChessPosition(sc);	//Lê a peça de captura
				
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(), possibleMoves);	//Imprime o tabuleiro com as posições posiveis
				
				System.out.println();
				System.out.println("Target: ");
				ChessPosition target = UI.readChessPosition(sc);	//Lê a posição desejada
				
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);	//Move a peça para o local desejado
			}catch(ChessException e) {	//Com esse tratamento o programa não quebra, continua funcionando
				System.out.println(e.getMessage());
				sc.nextLine();
			}catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
	}
}
