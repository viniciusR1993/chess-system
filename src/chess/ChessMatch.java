package chess;

import boardgame.Board;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

	private Board board;

	public ChessMatch() { // Esse é o construtor do tabuleiro dessa forma tem que chamar os outros metodos
		board = new Board(8, 8);
		initialSetup();
	}

	public ChessPiece[][] getPieces() { // Esse methodo retorna a matriz de peças de Xadres
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j); // Os for estão percorrendo as linhas e colunas do board e
															// adiciona a matriz mat essa peças
			} // Observe que é feito um ecapsulamento para ChessPiece
		}
		return mat;
	}

	private void placeNewPiece(char column, int row, ChessPiece piece) { // Esse metodo captura o que o usuario digita
																			// para decopliar para o programa
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}

	public void initialSetup() { // Methodo que seta as peças no tabuleiro
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
		placeNewPiece('c', 2, new Rook(board, Color.WHITE));
		placeNewPiece('d', 2, new Rook(board, Color.WHITE));
		placeNewPiece('e', 2, new Rook(board, Color.WHITE));
		placeNewPiece('e', 1, new Rook(board, Color.WHITE));
		placeNewPiece('d', 1, new King(board, Color.WHITE));

		placeNewPiece('c', 7, new Rook(board, Color.BLACK));
		placeNewPiece('c', 8, new Rook(board, Color.BLACK));
		placeNewPiece('d', 7, new Rook(board, Color.BLACK));
		placeNewPiece('e', 7, new Rook(board, Color.BLACK));
		placeNewPiece('e', 8, new Rook(board, Color.BLACK));
		placeNewPiece('d', 8, new King(board, Color.BLACK));
	}
}
