package chess;

import boardgame.Position;

public class ChessPosition {
	
	private char column;
	private int row;
	
	public ChessPosition(char column, int row) {
		if(column < 'a' || column > 'h' || row < 1 || row > 8) {	//programação defensiva. A posição da peça não pode sair do tabuleiro
			throw new ChessException("Error instantiating chessPosition. Valid value are frow a1 to h8.");
		}
		this.column = column;
		this.row = row;
	}

	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}

	protected Position toPosition() {
		return new Position(8 - row, column - 'a'); //8 - row é a linha correspondete no script, visto que as linha vão de 0 a 7, porém no laytout vai de 1 a 8 
	}											   //column - 'a' é a subtração do condigo unicode da colunam vusti que a coluna vai de 0 a 7, porém no layout vai de a até h.
	
	protected static ChessPosition fromPosition(Position position) {	//mesmo caso que o metodo acima porém inverso
		return new ChessPosition((char)('a' - position.getColumn()),8 - position.getRow());
	}
	
	@Override
	public String toString() {
		return "" + column + row;	//O string vazio é para força o copilador a concatenar as string
	}

}
