package ui.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import ui.view.panels.PlayerPanel;

public class View extends JFrame{

	private static final long serialVersionUID = -7999885517041228366L;
	
	private Controller controller;
	
	private PlayerPanel player1Panel;
	private PlayerPanel player2Panel;
	private JComboBox<ShipEnum> shipTypeCB;
	private JRadioButton horzRadio;
	private JRadioButton vertRadio;
	
	public View(){		
	
		settingsChangedListener settingsListener = new settingsChangedListener();
		
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
		shipTypeCB.addActionListener(settingsListener);
		leftPanel.add(shipTypeCB);
		
		JPanel tussenPanel = new JPanel();
		leftPanel.add(tussenPanel);
		
		JLabel richtinLbl = new JLabel("Richting");
		leftPanel.add(richtinLbl);
		
		JPanel radioButtonPanel = new JPanel();
		leftPanel.add(radioButtonPanel);
		radioButtonPanel.setLayout(new BoxLayout(radioButtonPanel, BoxLayout.X_AXIS));
		horzRadio = new JRadioButton("Horizontal");
		horzRadio.addActionListener(settingsListener);
		radioButtonPanel.add(horzRadio);
		vertRadio = new JRadioButton("Vertical");
		vertRadio.addActionListener(settingsListener);
		radioButtonPanel.add(vertRadio);
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(horzRadio);
		btnGroup.add(vertRadio);
		horzRadio.setSelected(true);
		contentPanel.add(leftPanel);
		
		//PlayerPanels
		
		player1Panel = new PlayerPanel(this.controller.getNameHuman(), this.controller.getBoardSize().getWidth(),this.controller.getBoardSize().getHeight());
		player1Panel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 5));
		player1Panel.setPlayerBoard(true);
		contentPanel.add(player1Panel);
		
		player2Panel = new PlayerPanel(this.controller.getNameComputer(), this.controller.getBoardSize().getWidth(),this.controller.getBoardSize().getHeight());
		player2Panel.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 10));
		player2Panel.setPlayerBoard(false);
		contentPanel.add(player2Panel);
		
		//show frame
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(this.getSize());
		settingsListener.actionPerformed(new ActionEvent(horzRadio, 0, ""));
		this.setVisible(true);
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
	
	private class settingsChangedListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(horzRadio.isSelected()){
				player1Panel.setShipPlaceOrientation(PlayerPanel.HORZ);
			}else if(vertRadio.isSelected()){
				player1Panel.setShipPlaceOrientation(PlayerPanel.VERT);
			}
			
			player1Panel.setCurrentShipTypePlacement((ShipEnum)shipTypeCB.getSelectedItem());
			
		}
		
	}
	
}
