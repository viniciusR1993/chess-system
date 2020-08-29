package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if(rows < 1 || columns < 1) {	//Programa��o defencisa (o tabuleiro deve ter pelo menos 1 linha e 1 coluna
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
		if(!positionExistis(row, column)) {	//Programa��o defenciva. A pe�a tem que existir.
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		if(!positionExistis(position)) {	//Programa��o defenciva. A pe�a tem que existir.
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {	//Ela pega uma pe�a e atribui uma posi��o
		if(thereIsAPiece(position)) {	//Programa��o defensiva. N�o coloca a pe�a em um lugar que ja existe uma pe�a
			throw new BoardException("There is already a piece on position " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;	//Eu n�o tinha visto ele colocar essa linha
	}
	
	public Piece removePiece(Position position) {
		if(!positionExistis(position)) {	//Programa��o defenciva. A pe�a tem que existir.
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
	
	public boolean positionExistis(Position position) {	//Retorna se uma position existe, igual o methodo acima por�m com valores diferentes
		return positionExistis(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) {
		if(!positionExistis(position)) {	//Programa��o defenciva. A pe�a tem que existir.
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;	
	}
	
	
	
}
