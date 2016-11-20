package domain.model;

import java.awt.Dimension;

public class BSBoard implements Board{
	
	private int[][] board;
	
	public BSBoard(){
		board = new int[10][10];
	}
	
	private void setBoard(int[][] board) {
		this.board = board;
	}

	@Override
	public Dimension getSize() {
		return new Dimension(board.length,board[0].length);
	}
	
	
	
}
