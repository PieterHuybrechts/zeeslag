package ui.view;

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

import common.Observer;
import domain.DomainException;
import domain.model.GameOverState;
import domain.model.GameState;
import domain.model.NewState;
import domain.model.ShipEnum;
import domain.model.ShipOrientationEnum;
import domain.model.StartedState;
import ui.controller.Controller;
import ui.view.panels.PlayerPanel;

public class View extends JFrame implements Observer{

	private static final long serialVersionUID = -7999885517041228366L;

	private Controller controller;
	private PlayerPanel player1Panel;
	private PlayerPanel player2Panel;
	private JComboBox<ShipEnum> shipTypeCB;
	private ButtonGroup radioButtonGroup;
	private JButton startButton;
	
	
	public View(Controller controller) {
		this.controller = controller;
	}
	
	public void startNameEntryView(){
		while (true) {
			try {
				String name = JOptionPane.showInputDialog(null, "What is your name?");
				if (name == null)
					System.exit(1);
				this.controller.addPlayer(name);
				break;
			} catch (DomainException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
			}
		}		
	}
	
	
	public void startGameView(){
		settingsChangedListener settingsListener = new settingsChangedListener();
		
		// ContentPane
		
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
		this.setContentPane(contentPanel);
		
		// LeftPanel
		
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
		radioButtonGroup = new ButtonGroup();
		radioButtonPanel.setLayout(new BoxLayout(radioButtonPanel, BoxLayout.X_AXIS));
		boolean first = true;
		
		for(ShipOrientationEnum o : ShipOrientationEnum.values()){
			JRadioButton temp = new JRadioButton(o.toString());
			temp.setActionCommand(o.toString());
			radioButtonGroup.add(temp);
			temp.addActionListener(settingsListener);
			radioButtonPanel.add(temp);
			
			if(first){
				temp.setSelected(true);
				first = false;
			}	
		}
		
		leftPanel.add(radioButtonPanel);
		
		leftPanel.add(new JPanel());
		leftPanel.add(new JPanel());
		leftPanel.add(new JPanel());
		
		startButton = new JButton("Start");
		startButton.addActionListener(new startButtonLister());
		leftPanel.add(startButton);
		
		contentPanel.add(leftPanel);
		
		// PlayerPanels
		
		player1Panel = new PlayerPanel(controller,true);
		player1Panel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 5));
		contentPanel.add(player1Panel);
		
		player2Panel = new PlayerPanel(controller,false);
		player2Panel.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 10));
		player2Panel.setButtonsEnabled(false);
		contentPanel.add(player2Panel);
		
		
		// show frame
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(this.getSize());
		settingsListener.actionPerformed(new ActionEvent(shipTypeCB, 0, ""));
		this.setVisible(true);
	}
	
	private class settingsChangedListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {			
			String text = radioButtonGroup.getSelection().getActionCommand();
			ShipOrientationEnum o=null;
			
			for(ShipOrientationEnum temp:ShipOrientationEnum.values()){
				if(temp.toString().equals(text)){
					o = temp;
					break;
				}
			}
			
			player1Panel.setCurrentShipOrientation(o);
			player1Panel.setCurrentShipType((ShipEnum) shipTypeCB.getSelectedItem());
		}
	}
	
	private class startButtonLister implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				controller.startGame();
				JButton button = (JButton)e.getSource();
				button.setEnabled(false);
			}
			catch(Exception ee){
				JOptionPane.showMessageDialog(null, ee.getMessage(),"WARNING",JOptionPane.WARNING_MESSAGE);
			}
		}
		
	}

	@Override
	public void update() {
		player1Panel.update();
		player2Panel.update();
		
		String className = controller.getGameState().getClass().getName();
		
		if(className.equals(NewState.class.getName())){
			player1Panel.setButtonsEnabled(true);
			player2Panel.setButtonsEnabled(false);
			startButton.setEnabled(true);
		}else if(className.equals(StartedState.class.getName())){
			player1Panel.setButtonsEnabled(false);
			player2Panel.setButtonsEnabled(true);
			startButton.setEnabled(false);
		}else if(className.equals(GameOverState.class.getName())){
			
		}
		
	}
}
