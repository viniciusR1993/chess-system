package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	
	private Board board;
	
	public ChessMatch() {	//Esse � o construtor do tabuleiro dessa forma tem que chamar os outros metodos
		board = new Board(8, 8);
		initialSetup();
	}

	public ChessPiece[][] getPieces(){	//Esse methodo retorna a matriz de pe�as de Xadres
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for(int i = 0; i<board.getRows(); i++) {
			for(int j =0; j<board.getColumns(); j++) {
				mat[i][j] = (ChessPiece)board.piece(i, j); //Os for est�o percorrendo as linhas e colunas do board e adiciona a matriz mat essa pe�as
			}											  //Observe que � feito um ecapsulamento para ChessPiece
		}
		return mat;
	}
	
	public void initialSetup() {	//Methodo que seta as pe�as no tabuleiro
		board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1));
		board.placePiece(new King(board, Color.BLACK), new Position(0, 4));
		board.placePiece(new King(board, Color.WHITE), new Position(7, 4));
	}
}
