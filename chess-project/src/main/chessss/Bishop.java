package chess;

class Bishop extends Piece{
	private PieceColour colour;
	private String symbol;

	Bishop(PieceColour pc){
		if (pc.equals(PieceColour.WHITE)){
			this.colour=PieceColour.WHITE;
			this.symbol="♗";
		}
		else if (pc.equals(PieceColour.BLACK)){
			this.colour=PieceColour.BLACK;
			this.symbol="♝";
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

		if (i1 > 7 || j1 > 7 || i1 < 0 || j1 < 0) {
			return false;
		}

		if ((i0-i1)*(i0-i1) != (j0-j1)*(j0-j1)) {
			return false;
		}

		if (validPath(i0, j0, i1, j1) && isCorrectFinalPosition(i0, j0, i1, j1)) {
			return true;
		} 
		else {
			return false;
		}
	}

	public boolean isCorrectFinalPosition(int i0, int j0, int i1, int j1) {
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
		int to = i0-i1;
		int xOffset = j1-j0;

		if (xOffset < 0) {
			xOffset = -1;
		} else {
			xOffset = 1;
		}

		if (to < 0) {
			for (int i = i0+1; i < i1; i++) {
				j0 = j0 + xOffset;
				if (Board.getPiece(i, j0) != null) {
					return false;
				}
			}
		} else {
			for (int i = i0-1; i > i1; i--) {
				j0 = j0 + xOffset;
				if (Board.getPiece(i, j0) != null) {
					return false;
				}
			}
		}

		return true;
	}
	
}
