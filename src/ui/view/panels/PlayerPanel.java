package ui.view.panels;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
	private ShipOrientationEnum selectedOrientation;
	private ShipEnum selectedShipType;
	private JButton[][] buttonArray;
	private boolean humanPlayer;
	private int boardWidth;
	private int boardHeight;
	private Controller controller;
	
	public static final int HORZ = 0;
	public static final int VERT = 1;
	
	public PlayerPanel(Controller c,boolean humanPlayer){
		controller = c;
		boardWidth = c.getBoardSize().getWidth();
		boardHeight = c.getBoardSize().getHeight();
		this.humanPlayer = humanPlayer;
		buttonArray = new JButton[10][10];		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel contentPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) contentPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(contentPanel);
		
		String name;
		if(humanPlayer)
			name = c.getNameHuman();
		else
			name = c.getNameComputer();
		
		JLabel nameLbl = new JLabel(name);
		contentPanel.add(nameLbl);
		
		JPanel buttonPanel = new JPanel(new GridLayout(boardHeight,boardWidth));
		for(int y=0;y<boardHeight;y++){
			for(int x=0;x<boardWidth;x++){
				//y=row
				//x=column
				JButton tempButton = new JButton();
				tempButton.setActionCommand(x+";"+y);
				tempButton.addMouseListener(new BtnHoverListener());
				tempButton.setPreferredSize(new Dimension(20,20));
				buttonPanel.add(tempButton);
				buttonArray[x][y] = tempButton;
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
	
	public boolean isPlayerBoard() {
		return humanPlayer;
	}
	
	private class BtnHoverListener implements MouseListener{
		@Override
		public void mouseEntered(MouseEvent e) {			
			changeColor(e,new Color(255,255,255));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			changeColor(e,btnBackGroundColor);
		}
		
		private void changeColor(MouseEvent e,Color c){
			if(isPlayerBoard()){	
				JButton btn = (JButton)e.getSource();
				btn.setBackground(new Color(255,255,255));
				String pos = btn.getActionCommand();
				int x = Integer.parseInt(pos.substring(0, pos.indexOf(';')));
				int y = Integer.parseInt(pos.substring(pos.indexOf(';')+1,pos.length()));
				int length = selectedShipType.getLength();
				
				for(int i=0;i<length;i++){
					if(selectedOrientation == ShipOrientationEnum.HORIZONTAL){
						if(x+i<boardWidth)
							buttonArray[x+i][y].setBackground(c);
					}else if(selectedOrientation == ShipOrientationEnum.VERTICAL){
						if(y+i<boardHeight)
							buttonArray[x][y+i].setBackground(c);
					}
				}
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseClicked(MouseEvent e) {
			JButton button = (JButton)e.getComponent();
			String pos = button.getActionCommand();
			int x = Integer.parseInt(pos.substring(0, pos.indexOf(';')));
			int y = Integer.parseInt(pos.substring(pos.indexOf(';')+1,pos.length()));
			
			controller.addShip(selectedShipType, new Position(x, y));
		}		
	}
}
