package ui.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import domain.DomainException;
import ui.controller.Controller;

public class View extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7999885517041228366L;
	
	private Controller controller;
	
	public View(){
		try{
			controller = new Controller();			
		}catch(DomainException e){
			JOptionPane.showMessageDialog(null, e.getMessage(),"Warning",JOptionPane.WARNING_MESSAGE);
			System.exit(1);
		}
		String name = "Human";
		try{
		name = JOptionPane.showInputDialog("What is the name of the player?");
		}
		catch(Exception e){
			
		}
		this.controller.addPlayer(name);
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new BoxLayout(contentPanel,BoxLayout.X_AXIS));
		this.setContentPane(contentPanel);

		
		JPanel player1Panel = new JPanel();
		player1Panel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 5));
		player1Panel.setLayout(new BoxLayout(player1Panel, BoxLayout.Y_AXIS));
		JLabel player1NameLbl = new JLabel(this.controller.getBoardGame().getNameHuman());
		player1Panel.add(player1NameLbl);
		player1Panel.add(createButtonPanel());
		contentPanel.add(player1Panel);
		
		JPanel player2Panel = new JPanel();
		player2Panel.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 10));
		player2Panel.setLayout(new BoxLayout(player2Panel, BoxLayout.Y_AXIS));
		JLabel player2NameLbl = new JLabel(this.controller.getBoardGame().getNameComputer());
		player2Panel.add(player2NameLbl);
		player2Panel.add(createButtonPanel());
		contentPanel.add(player2Panel);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private JPanel createButtonPanel(){
		int length=(int)controller.getBoardSize().getWidth();
		int height=(int)controller.getBoardSize().getHeight();

		JPanel buttonPanel = new JPanel(new GridLayout(length,height));
		
		for(int i=0;i<length;i++){
			for(int j=0;j<height;j++){
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.gridx=i;
				gbc.gridy=j;
				JButton tempButton = new JButton();
				tempButton.setPreferredSize(new Dimension(20,20));
				buttonPanel.add(tempButton,gbc);
			}
		}
		
		
		return buttonPanel;
	}
	
}
