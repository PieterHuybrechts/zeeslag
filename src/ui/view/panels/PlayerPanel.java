package ui.view.panels;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import domain.model.ShipEnum;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.SwingConstants;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.SharedInputStream;


public class PlayerPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5929386468142332772L;
	private final Color btnBackGroundColor = new JButton().getBackground();
	private int selectedOrientation;
	private ShipEnum selectedShipType;
	private JButton[][] buttonArray;
	private boolean playerBoard;
	private int boardWidth;
	private int boardHeight;
	
	public static final int HORZ = 0;
	public static final int VERT = 1;
	
	public PlayerPanel(String playerName,int width,int height){
		
		boardWidth = width;
		boardHeight = height;
		playerBoard = false;
		buttonArray = new JButton[10][10];		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel);
		
		JLabel nameLbl = new JLabel(playerName);
		panel.add(nameLbl);

		JPanel buttonPanel = new JPanel(new GridLayout(width,height));
		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.gridx=i;
				gbc.gridy=j;
				JButton tempButton = new JButton();
				tempButton.setActionCommand(i+";"+j);
				tempButton.addMouseListener(new BtnHoverListener());
				tempButton.setPreferredSize(new Dimension(20,20));
				buttonPanel.add(tempButton,gbc);
				buttonArray[i][j] = tempButton;
			}
		}
		add(buttonPanel);
	}
	
	public void setShipPlaceOrientation(int arg0){
		if(arg0!= HORZ && arg0!=VERT){
			arg0=HORZ;
		}
		
		selectedOrientation = arg0;
	}
	
	public void setCurrentShipTypePlacement(ShipEnum shipType){
		selectedShipType = shipType;
	}
	
	public void setPlayerBoard(boolean playerBoard) {
		this.playerBoard = playerBoard;
	}
	
	public boolean isPlayerBoard() {
		return playerBoard;
	}
	
	@Override
	public void setEnabled(boolean enabled){
		super.setEnabled(enabled);
		
		for(int i=0;i<buttonArray.length;i++){
			for(int j=0;j<buttonArray[0].length;j++){
				buttonArray[i][j].setEnabled(enabled);
			}
		}
		
	}
	
	private class BtnHoverListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			if(isPlayerBoard()){
				JButton btn = (JButton)e.getSource();
				btn.setBackground(new Color(255,255,255));
				String pos = btn.getActionCommand();
				int x = Integer.parseInt(pos.substring(0, pos.indexOf(';')));
				int y = Integer.parseInt(pos.substring(pos.indexOf(';')+1,pos.length()));
				int length = selectedShipType.getLength();
				
				for(int i=0;i<length;i++){
					if(selectedOrientation == HORZ){
						if(x+i<boardWidth)
							buttonArray[x+i][y].setBackground(new Color(255,255,255));
					}else if(selectedOrientation == VERT){
						if(y+i<boardHeight)
							buttonArray[x][y+i].setBackground(new Color(255,255,255));
					}
				}
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if(isPlayerBoard()){	
				JButton btn = (JButton)e.getSource();
				btn.setBackground(new Color(255,255,255));
				String pos = btn.getActionCommand();
				int x = Integer.parseInt(pos.substring(0, pos.indexOf(';')));
				int y = Integer.parseInt(pos.substring(pos.indexOf(';')+1,pos.length()));
				int length = selectedShipType.getLength();
				
				for(int i=0;i<length;i++){
					if(selectedOrientation == HORZ){
						if(x+i<boardWidth)
							buttonArray[x+i][y].setBackground(btnBackGroundColor);
					}else if(selectedOrientation == VERT){
						if(y+i<boardHeight)
							buttonArray[x][y+i].setBackground(btnBackGroundColor);
					}
				}
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		
	}
	
}
