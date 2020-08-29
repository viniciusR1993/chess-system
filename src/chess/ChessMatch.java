package chess;

import boardgame.Board;

public class ChessMatch {
	
	private Board board;
	
	public ChessMatch() {
		board = new Board(8, 8);
	}

	public ChessPiece[][] getPieces(){	//Esse methodo retorna a matriz de peças de Xadres
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for(int i = 0; i<board.getRows(); i++) {
			for(int j =0; j<board.getColumns(); j++) {
				mat[i][j] = (ChessPiece)board.piece(i, j); //Os for estão percorrendo as linhas e colunas do board e adiciona a matriz mat essa peças
			}											  //Observe que é feito um ecapsulamento para ChessPiece
		}
		return mat;
	}
}
