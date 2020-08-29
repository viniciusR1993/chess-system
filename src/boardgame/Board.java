package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if(rows < 1 || columns < 1) {	//Programação defencisa (o tabuleiro deve ter pelo menos 1 linha e 1 coluna
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	public Piece piece(int row, int column) {
		if(!positionExistis(row, column)) {	//Programação defenciva. A peça tem que existir.
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		if(!positionExistis(position)) {	//Programação defenciva. A peça tem que existir.
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {	//Ela pega uma peça e atribui uma posição
		if(thereIsAPiece(position)) {	//Programação defensiva. Não coloca a peça em um lugar que ja existe uma peça
			throw new BoardException("There is already a piece on position " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;	//Eu não tinha visto ele colocar essa linha
	}
	
	public Piece removePiece(Position position) {
		if(!positionExistis(position)) {	//Programação defenciva. A peça tem que existir.
			throw new BoardException("Position not on the board");
		}
		if(piece(position) == null) {
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}
	
	private boolean positionExistis(int row, int column) {	//retorna se uma position existe
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	public boolean positionExistis(Position position) {	//Retorna se uma position existe, igual o methodo acima porém com valores diferentes
		return positionExistis(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) {
		if(!positionExistis(position)) {	//Programação defenciva. A peça tem que existir.
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;	
	}
	
	
	
}
