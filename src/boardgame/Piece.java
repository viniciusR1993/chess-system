package boardgame;

public class Piece {
	
	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		position = null; //Pode não colocar devido o java atribuir null quando não é declarado
	}

	protected Board getBoard() {
		return board;
	}
	
	//O tabuleiro associado a uma peça não pode ser acessado por outros pacotes ou outras classes, apenas por sub-classes.
	//Dessa forma evita erro de programação.
	
}
