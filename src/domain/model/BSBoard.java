package domain.model;

import domain.model.lib.BoardDimension;

public class BSBoard implements Board{
	
	private int[][] board;
	private BoardDimension dimension;
	
	public BSBoard(){
		board = new int[10][10];
		dimension = new BoardDimension(10, 10);
	}
	
	private void setBoard(int[][] board) {
		this.board = board;
	}

	@Override
	public BoardDimension getSize() {
		return dimension;
	}
	
	
	
}
