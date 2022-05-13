package chess;

public class Knight extends Piece{
	private PieceColour colour;
	private String symbol;

 	public Knight(PieceColour pc){
		if (pc.equals(PieceColour.WHITE)){
			this.colour=PieceColour.WHITE;
			this.symbol="♘";
		}
		else if (pc.equals(PieceColour.BLACK)){
			this.colour=PieceColour.BLACK;
			this.symbol="♞";
		}
	}

	public String getSymbol(){
		return symbol;
	}
	public PieceColour getColour(){
		return colour;
	}

	@Override
	public boolean isLegitMove(int i0, int j0, int i1, int j1) {



		if (i1 == i0+1 || i1 == i0-1) {
			if (j1 == j0+2 || j1 == j0-2) {
				if (isCorrectFinalPosition(i1, j1) && validPath(i0, j0, i1, j1)) {
					return true;
				}
			}
		}
		if (i1 == i0+2 || i1 == i0-2) {
			if (j1 == j0+1 || j1 == j0-1) {
				if (isCorrectFinalPosition(i1, j1) && validPath(i0, j0, i1, j1)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isCorrectFinalPosition(int i1, int j1) {
		if (Board.getPiece(i1, j1) == null) {
			return true;
		}
		else if (this.colour == PieceColour.WHITE && Board.getPiece(i1, j1).getColour() == PieceColour.BLACK) {
			return true;
		}
		else if (this.colour == PieceColour.BLACK && Board.getPiece(i1, j1).getColour() == PieceColour.WHITE) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean validPath(int i0, int j0, int i1, int j1) {

		if (i1 == i0+1 && j1 == j0+2) {
			if (isValidPosition(i0+1, j0) && isValidPosition(i0+1, j0+1)) {
				return true;
			}
			else if (isValidPosition(i0, j0+1) && isValidPosition(i0, j0+2)) {
				return true;
			}
			else {
				return false;
			}
		}
		else if (i1 == i0+1 && j1 == j0-2) {
			if (isValidPosition(i0+1, j0) && isValidPosition(i0+1, j0-1)) {
				return true;
			}
			else if (isValidPosition(i0, j0-1) && isValidPosition(i0, j0-2)) {
				return true;
			}
			else {
				return false;
			}
		}
		else if (i1 == i0-1 && j1 == j0+2) {
			if (isValidPosition(i0-1, j0) && isValidPosition(i0-1, j0+1)) {
				return true;
			}
			else if (isValidPosition(i0, j0+1) && isValidPosition(i0, j0+2)) {
				return true;
			}
			else {
				return false;
			}
		}
		else if (i1 == i0-1 && j1 == j0-2) {
			if (isValidPosition(i0-1, j0) && isValidPosition(i0-1, j0-1)) {
				return true;
			}
			else if (isValidPosition(i0, j0-1) && isValidPosition(i0, j0-2)) {
				return true;
			}
			else {
				return false;
			}
		}
		else if (i1 == i0+2 && j1 == j0+1) {
			if (isValidPosition(i0+1, j0) && isValidPosition(i0+2, j0)) {
				return true;
			}
			else if (isValidPosition(i0, j0+1) && isValidPosition(i0+1, j0+1)) {
				return true;
			}
			else {
				return false;
			}
		}
		else if (i1 == i0+2 && j1 == j0-1) {
			if (isValidPosition(i0+1, j0) && isValidPosition(i0+2, j0)) {
				return true;
			}
			else if (isValidPosition(i0, j0-1) && isValidPosition(i0+1, j0-1)) {
				return true;
			} 
			else {
				return false;
			}
		}
		else if (i1 == i0-2 && j1 == j0+1) {
			if (isValidPosition(i0-1, j0) && isValidPosition(i0-2, j0)) {
				return true;
			}
			else if (isValidPosition(i0, j0+1) && isValidPosition(i0-1, j0+1)) {
				return true;
			}
			else {
				return false;
			}
		}
		else if (i1 == i0-2 && j1 == j0-1) {
			if (isValidPosition(i0-1, j0) && isValidPosition(i0-2, j0)) {
				return true;
			} 
			else if (isValidPosition(i0, j0-1) && isValidPosition(i0-1, j0-1)) {
				return true;
			}
			else {
				return false;
			}

		}
		else {
			return false;
		}
		
	}

	public boolean isValidPosition(int i, int j) {
		if (Board.getPiece(i, j) == null) {
			return true;
		}
		else if (Board.getPiece(i, j).getColour() == this.colour) {
			return true;
		}
		else {
			return false;
		}
	}

}
