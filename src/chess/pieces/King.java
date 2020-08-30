package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	public King(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "K";
	}

	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()]; // Provisorio

		Position p = new Position(0, 0);

		// above - testa posição acima
		p.setValues(position.getRow() - 1, position.getColumn());
		if (getBoard().positionExistis(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// below - testa posição abaixo
		p.setValues(position.getRow() + 1, position.getColumn());
		if (getBoard().positionExistis(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// left - testa posição esquerda
		p.setValues(position.getRow(), position.getColumn() - 1);
		if (getBoard().positionExistis(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// right - testa posição direita
		p.setValues(position.getRow(), position.getColumn() + 1);
		if (getBoard().positionExistis(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// nw - testa posição noroeste
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		if (getBoard().positionExistis(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// ne - testa posição nordeste
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		if (getBoard().positionExistis(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// sw - testa posição sudoeste
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		if (getBoard().positionExistis(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// se - testa posição sudeste
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		if (getBoard().positionExistis(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		return mat;
	}

}
