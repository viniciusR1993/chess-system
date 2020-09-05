package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		List<ChessPiece> captured = new ArrayList<>();
		
		while(!chessMatch.getCheckMate()) {
			try {
				UI.clearScreen();	//Limpa a tela
				UI.printMatch(chessMatch, captured);	//Imprime o tabuleiro	
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
				
				if(capturedPiece != null) {		//Se a peça capturad for diferente de nula, ele adiciona a lista
					captured.add(capturedPiece);
				}
				
				if(chessMatch.getPromoted() != null) {
					System.out.println("Enter piece for promotion (B/N/Q/R): ");
					String type = sc.nextLine();
					chessMatch.replacePromotedPiece(type);
				}
			}catch(ChessException e) {	//Com esse tratamento o programa não quebra, continua funcionando
				System.out.println(e.getMessage());
				sc.nextLine();
			}catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
		UI.clearScreen();
		UI.printMatch(chessMatch, captured);
	}
}
