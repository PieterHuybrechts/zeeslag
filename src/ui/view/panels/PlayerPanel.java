package ui.view.panels;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import domain.DomainException;
import domain.model.BSBoard;
import domain.model.Ship;
import domain.model.ShipEnum;
import domain.model.ShipOrientationEnum;
import domain.model.lib.Position;
import ui.controller.Controller;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.Dimension;

public class PlayerPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5929386468142332772L;
	private final Color btnBackGroundColor = new JButton().getBackground();
	
	private Controller controller;
	private boolean humanPlayer;
	private BSBoard board;
	private JButton[][] buttonMatrix;
	private ShipOrientationEnum selectedOrientation;
	private ShipEnum selectedShipType;
	
	public PlayerPanel(Controller c,boolean humanPlayer){
		controller = c;
		this.humanPlayer = humanPlayer;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		String name;
		int boardWidth;
		int boardHeight;
		
		if(humanPlayer){
			board = c.GetHumanBoard();
			name = c.getNameHuman();
		}else{
			board = c.getComputerBoard();
			name = c.getNameComputer();
			
			
			
			
		}
		
		boardWidth = board.getSize().getWidth();
		boardHeight = board.getSize().getHeight();
		
		
		buttonMatrix = new JButton[boardWidth][boardHeight];
		
		//Name label
		
		JPanel nameLblPnl = new JPanel();
		FlowLayout flowLayout = (FlowLayout) nameLblPnl.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(nameLblPnl);		
		JLabel nameLbl = new JLabel(name);
		nameLblPnl.add(nameLbl);
		
		//ButtonPanel
		
		JPanel buttonPanel = new JPanel(new GridLayout(boardHeight,boardWidth));
		BtnListener btnListener = new BtnListener();
		Dimension d = new Dimension(25, 25);
		for(int y=0;y<boardHeight;y++){
			for(int x=0;x<boardWidth;x++){
				//y=row
				//x=column
				JButton tempButton = new JButton();
				tempButton.setActionCommand(x+";"+y);
				tempButton.addMouseListener(btnListener);					
				tempButton.setPreferredSize(d);
				buttonPanel.add(tempButton);
				buttonMatrix[x][y] = tempButton;
			}
		}
		
		add(buttonPanel);
	}
	
	public void setCurrentShipOrientation(ShipOrientationEnum o){
		selectedOrientation = o;
	}
	
	public void setCurrentShipType(ShipEnum shipType){
		selectedShipType = shipType;
	}
	
	public boolean isHumanBoard() {
		return humanPlayer;
	}

	public void update() {		
		if(isHumanBoard()){
			board = controller.GetHumanBoard();
		}else{
			board = controller.getComputerBoard();
		}
		
				
		
	}
	
	private class BtnListener implements MouseListener{
		@Override
		public void mouseEntered(MouseEvent e) {
			if(isHumanBoard()){
				if(board.isValidMove(selectedShipType,selectedOrientation,getPos(e))){
					changeColor(e,new Color(255,255,255));
				}else{
					changeColor(e,new Color(255,75,75));
				}
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if(isHumanBoard())
				changeColor(e,btnBackGroundColor);
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			Position p = getPos(e);
			
			if(isHumanBoard()){
				try {
					//System.out.println("x: " + p.getX() + "   y:  " +p.getY());
					controller.addShip(selectedShipType, p,selectedOrientation);
				} catch (DomainException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"Warning",JOptionPane.WARNING_MESSAGE);
				}
			}
			
			mouseEntered(e);
		}	
		
		private Position getPos(MouseEvent e){
			JButton btn = (JButton)e.getSource();
			String pos = btn.getActionCommand();
			int x = Integer.parseInt(pos.substring(0, pos.indexOf(';')));				
			int y = Integer.parseInt(pos.substring(pos.indexOf(';')+1,pos.length()));
			return new Position(x, y);
		}
		
		
		private void changeColor(MouseEvent e,Color c){
			Position p = getPos(e);

			if(isHumanBoard()){		
				
				int x = p.getX();
				int y = p.getY();
				int length = selectedShipType.getLength();
				
				for(int i=0;i<length;i++){
					if(selectedOrientation == ShipOrientationEnum.HORIZONTAL){
						if(x+i<board.getSize().getWidth())
							buttonMatrix[x+i][y].setBackground(c);
					}else if(selectedOrientation == ShipOrientationEnum.VERTICAL){
						if(y+i<board.getSize().getHeight())
							buttonMatrix[x][y+i].setBackground(c);
					}
				}
								
				
			}
			
			for(Ship s : board.getShips()){
				int xPos = s.getPos().getX();
				int yPos = s.getPos().getY();
				
				for(int i = 0;i<s.getLength();i++){
					if(s.getOrientation() == ShipOrientationEnum.VERTICAL){
						buttonMatrix[xPos][yPos+i].setBackground(new Color(100,100,100));
					}else if(s.getOrientation() == ShipOrientationEnum.HORIZONTAL){
						buttonMatrix[xPos+i][yPos].setBackground(new Color(100,100,100));
					}
				}	
			}		
		}
		
		@Override
		public void mousePressed(MouseEvent e) {}
		
		@Override
		public void mouseReleased(MouseEvent e) {}
	}

}
