package chess;

public class King extends Piece{
	private PieceColour colour;
	private String symbol;

	public King(PieceColour pc){
		if (pc.equals(PieceColour.WHITE)){
			this.colour=PieceColour.WHITE;
			this.symbol="♔";
		}
		else if (pc.equals(PieceColour.BLACK)){
			this.colour=PieceColour.BLACK;
			this.symbol="♚";
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

		int iOffset = i0 - i1;
		int jOffset = j1 - j0;

		if (jOffset*jOffset > 1 || iOffset*iOffset > 1) {
			return false;
		}
		else if (Board.getPiece(i1, j1) == null) {
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
}
