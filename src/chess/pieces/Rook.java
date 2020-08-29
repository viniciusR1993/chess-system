package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece { // Torre

	public Rook(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "R";
	}

	@Override
	public boolean[][] possibleMoves() { // Move pra cima e pra baixo, esquerda e direita. até não ter peça aliada ou
											// até ter uma peça adversaria para captura
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()]; // Provisorio

		Position p = new Position(0, 0);

		// above - percorre as possibilidade acima
		p.setValues(position.getRow() - 1, position.getColumn());
		while (getBoard().positionExistis(p) && !getBoard().thereIsAPiece(p)) { // repete enquanto existir casas e se
																				// essa casa possui peça
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() - 1);
		}
		if (getBoard().positionExistis(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// below - percorre as possibilidade abaixo
		p.setValues(position.getRow() + 1, position.getColumn());
		while (getBoard().positionExistis(p) && !getBoard().thereIsAPiece(p)) { // repete enquanto existir casas e se
																				// essa casa possui peça
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() + 1);
		}
		if (getBoard().positionExistis(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// left - percorre as possibilidade a esquerda
		p.setValues(position.getRow(), position.getColumn() - 1);
		while (getBoard().positionExistis(p) && !getBoard().thereIsAPiece(p)) { // repete enquanto existir casas e se
																				// essa casa possui peça
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() - 1);
		}
		if (getBoard().positionExistis(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// right - percorre as possibilidade a direita
		p.setValues(position.getRow(), position.getColumn() + 1);
		while (getBoard().positionExistis(p) && !getBoard().thereIsAPiece(p)) { // repete enquanto existir casas e se
																				// essa casa possui peça
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() + 1);
		}
		if (getBoard().positionExistis(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		return mat;
	}
}
