package chess;

import boardgame.Position;

public class ChessPosition {
	
	private char column;
	private int row;
	
	public ChessPosition(char column, int row) {
		if(column < 'a' || column > 'h' || row < 1 || row > 8) {	//programa��o defensiva. A posi��o da pe�a n�o pode sair do tabuleiro
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
		return new Position(8 - row, column - 'a'); //8 - row � a linha correspondete no script, visto que as linha v�o de 0 a 7, por�m no laytout vai de 1 a 8 
	}											   //column - 'a' � a subtra��o do condigo unicode da colunam vusti que a coluna vai de 0 a 7, por�m no layout vai de a at� h.
	
	protected static ChessPosition fromPosition(Position position) {	//mesmo caso que o metodo acima por�m inverso
		return new ChessPosition((char)('a' - position.getColumn()),8 - position.getRow());
	}
	
	@Override
	public String toString() {
		return "" + column + row;	//O string vazio � para for�a o copilador a concatenar as string
	}

}
