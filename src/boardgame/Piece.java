//O tabuleiro associado a uma peça não pode ser acessado por outros pacotes ou outras classes, apenas por sub-classes.
//Dessa forma evita erro de programação.
package boardgame;

public abstract class Piece {
	
	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		position = null; //Pode não colocar devido o java atribuir null quando não é declarado
	}

	protected Board getBoard() {
		return board;
	}
	
	public abstract boolean[][] possibleMoves();	//Força as peças a terem o metodo que retorna matriz de movimentos possiveis
	
	public boolean possibleMove(Position position) {	//Retorna se é possivel um movimento
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
