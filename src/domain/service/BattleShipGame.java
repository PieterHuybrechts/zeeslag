package domain.service;

import java.awt.Dimension;

import domain.DomainException;
import domain.model.Computer;
import domain.model.Human;
import domain.model.Player;

public class BattleShipGame implements BoardGame{

	private Player human;
	private Player computer;
	
	public BattleShipGame() throws DomainException{
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

	public void addHuman(String name) throws DomainException {
		this.human = new Human(name);
	}
	
}
