package ui.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ColorModel;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import domain.DomainException;
import domain.model.ShipEnum;
import ui.controller.Controller;

public class View extends JFrame{

	private static final long serialVersionUID = -7999885517041228366L;
	
	private Controller controller;
	
	private JPanel player1Panel;
	private JPanel player2Panel;
	private JComboBox<ShipEnum> shipTypeCB;
	private JRadioButton horzRadio;
	private JRadioButton vertRadio;
	
	Color backGroundColor;
	
	public View(){		
		backGroundColor = new JButton().getBackground();
		try{
			controller = new Controller();			
		}catch(DomainException e){
			JOptionPane.showMessageDialog(null, e.getMessage(),"Warning",JOptionPane.WARNING_MESSAGE);
			System.exit(1);
		}
		
		while(true){
			try{
				String name = JOptionPane.showInputDialog(null, "What is your name?");
				if(name == null)
					System.exit(1);
				this.controller.addPlayer(name);		
				break;
			}catch(DomainException e){
				JOptionPane.showMessageDialog(null, e.getMessage(),"Warning",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		//ContentPane
		
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new BoxLayout(contentPanel,BoxLayout.X_AXIS));
		this.setContentPane(contentPanel);
		
		//LeftPanel
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		leftPanel.setLayout(new GridLayout(10, 0, 0, 0));
		
		JLabel beschikbareSchepenLbl = new JLabel("Beschikbare schepen");
		leftPanel.add(beschikbareSchepenLbl);
		
		shipTypeCB = new JComboBox<ShipEnum>(ShipEnum.values());
		leftPanel.add(shipTypeCB);
		
		
		JPanel tussenPanel = new JPanel();
		leftPanel.add(tussenPanel);
		
		
		JLabel richtinLbl = new JLabel("Richting");
		leftPanel.add(richtinLbl);
		
		
		JPanel radioButtonPanel = new JPanel();
		leftPanel.add(radioButtonPanel);
		radioButtonPanel.setLayout(new BoxLayout(radioButtonPanel, BoxLayout.X_AXIS));
		
		horzRadio = new JRadioButton("Horizontal");
		radioButtonPanel.add(horzRadio);
		
		vertRadio = new JRadioButton("Vertical");
		radioButtonPanel.add(vertRadio);
		
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(horzRadio);
		btnGroup.add(vertRadio);
		
		horzRadio.setSelected(true);
		
		contentPanel.add(leftPanel);
		
		
		//Player1Panel
		
		player1Panel = new JPanel();
		player1Panel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 5));
		player1Panel.setLayout(new BoxLayout(player1Panel, BoxLayout.Y_AXIS));
		JLabel player1NameLbl = new JLabel(this.controller.getNameHuman());
		player1Panel.add(player1NameLbl);
		player1Panel.add(createButtonPanel());
		contentPanel.add(player1Panel);
		
		//player2panel
		
		player2Panel = new JPanel();
		player2Panel.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 10));
		player2Panel.setLayout(new BoxLayout(player2Panel, BoxLayout.Y_AXIS));
		JLabel player2NameLbl = new JLabel(this.controller.getNameComputer());
		player2Panel.add(player2NameLbl);
		player2Panel.add(createButtonPanel());
		contentPanel.add(player2Panel);
		
		
	
		
		//show frame
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(this.getSize());
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
				tempButton.addMouseListener(new BtnHoverListener());
				tempButton.setPreferredSize(new Dimension(20,20));
				buttonPanel.add(tempButton,gbc);
			}
		}
		
		
		return buttonPanel;
	}
	
	private GridBagConstraints createGbc(int x,int y){
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.anchor = GridBagConstraints.WEST;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
		
		return gbc;
	}
	
	private class BtnHoverListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			JButton btn = (JButton)e.getSource();
			btn.setBackground(new Color(255,255,255));
			ShipEnum type = (ShipEnum) shipTypeCB.getSelectedItem();
			
		
			
			/*if(horzRadio.isSelected()){
				
			}else if(vertRadio.isSelected()){
				
			}*/
		}

		@Override
		public void mouseExited(MouseEvent e) {
			JButton btn = (JButton)e.getSource();
			btn.setBackground(backGroundColor);
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
