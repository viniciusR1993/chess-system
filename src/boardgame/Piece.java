//O tabuleiro associado a uma pe�a n�o pode ser acessado por outros pacotes ou outras classes, apenas por sub-classes.
//Dessa forma evita erro de programa��o.
package boardgame;

public abstract class Piece {
	
	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		position = null; //Pode n�o colocar devido o java atribuir null quando n�o � declarado
	}

	protected Board getBoard() {
		return board;
	}
	
	public abstract boolean[][] possibleMoves();	//For�a as pe�as a terem o metodo que retorna matriz de movimentos possiveis
	
	public boolean possibleMove(Position position) {	//Retorna se � possivel um movimento
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	public boolean isThereAnyPossibleMove() {	//metodo que retorna se existe algum movimento possivel
		boolean[][] mat = possibleMoves();
		for(int i = 0; i < mat.length; i++) {	//percorre a matriz de possibilidades
			for(int j = 0; j < mat.length; j++) {
				if(mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
}
