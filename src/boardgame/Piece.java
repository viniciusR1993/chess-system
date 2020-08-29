package boardgame;

public class Piece {
	
	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		position = null; //Pode n�o colocar devido o java atribuir null quando n�o � declarado
	}

	protected Board getBoard() {
		return board;
	}
	
	//O tabuleiro associado a uma pe�a n�o pode ser acessado por outros pacotes ou outras classes, apenas por sub-classes.
	//Dessa forma evita erro de programa��o.
	
}
