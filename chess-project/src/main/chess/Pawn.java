package chess;

public class Pawn extends Piece{
	private PieceColour colour;
	private String symbol;

	public Pawn(PieceColour pc){
		if (pc.equals(PieceColour.WHITE)){
			this.colour=PieceColour.WHITE;
			this.symbol="♙";
		}
		else if (pc.equals(PieceColour.BLACK)){
			this.colour=PieceColour.BLACK;
			this.symbol="♟";
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

		if (this.colour == PieceColour.WHITE) {
			int iOffsetWhite = i0 - i1;
			int jOffset = j1 - j0;
			if (iOffsetWhite == 1) {
				if (jOffset == 0 && Board.getPiece(i1, j1) == null) {
					return true;
				}
				else if (jOffset*jOffset == 1 && Board.getPiece(i1, j1) != null) {
					if (Board.getPiece(i1,j1).getColour() == PieceColour.BLACK) {
						return true;
					} else {
						return false;
					}
				}
				else {
					return false;
				}
			}
			else if (iOffsetWhite == 2 && jOffset == 0 && Board.getPiece(i1, j1) == null && i0 == 6) {
				return true;
			}
			else {
				return false;
			}
		}
		else if (this.colour == PieceColour.BLACK) {
			int iOffsetBlack = i1 - i0;
			int jOffset = j1 - j0;
			if (iOffsetBlack == 1) {
				if (jOffset == 0 && Board.getPiece(i1, j1) == null) {
					return true;
				}
				else if (jOffset*jOffset == 1 && Board.getPiece(i1, j1) != null) {
					if (Board.getPiece(i1,j1).getColour() == PieceColour.WHITE) {
						return true;
					} else {
						return false;
					}
				}
				else {
					return false;
				}
			}
			else if (iOffsetBlack == 2 && jOffset == 0 && Board.getPiece(i1, j1) == null && i0 == 1) {
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
}
