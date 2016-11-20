package domain.service;

import java.awt.Dimension;

import domain.DomainException;
import domain.model.Computer;
import domain.model.Human;
import domain.model.Player;

public class BattleShip implements BoardGame{

	private Player human;
	private Player computer;
	
	public BattleShip() throws DomainException{
		human = new Human("Human");
		computer = new Computer("Computer");
	}
	
	public Dimension getBoardSize(){
		return human.getBoard().getSize();
	}
	public String getNameHuman(){
		return this.human.getName();
	}
	public String getNameComputer(){
		
	return this.computer.getName();
	}
	@Override
	public void Start() {
		//TODO implement
	}

	public void addHuman(String name) {
		// TODO Auto-generated method stub
		try {
			this.human = new Human(name);
		} catch (DomainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
