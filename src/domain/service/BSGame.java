package domain.service;

import domain.DomainException;
import domain.model.Computer;
import domain.model.Human;
import domain.model.Player;
import domain.model.Ship;
import domain.model.ShipOrientationEnum;
import domain.model.lib.BoardDimension;
import domain.model.lib.Position;

public class BSGame implements BoardGame{

	private Player human;
	private Player computer;
	
	public BSGame() throws DomainException{
		human = new Human("Human");
		computer = new Computer("Computer");
	}
	
	public BoardDimension getBoardSize(){
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

	@Override
	public void addPion(Object pion, Position position, ShipOrientationEnum orientation) {
		//TODO addShip in human
		this.human.addShip((Ship) pion, position, orientation);
		
	}
}
