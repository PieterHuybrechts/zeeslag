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

	@Override
	public void Start() {
		//TODO implement
	}
	
}
