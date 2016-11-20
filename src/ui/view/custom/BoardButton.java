package ui.view.custom;

import javax.swing.JButton;


public class BoardButton extends JButton{
	private int x;
	private int y;
	
	public BoardButton(int x,int y) {
		setX(x);
		setY(y);
	}
	
	private void setX(int x){
		this.x=x;
	}
	
	private void setY(int y){
		this.y=y;
	}

}
