package domain.service;

import domain.DomainException;
import domain.model.Board;
import domain.model.Ship;
import domain.model.ShipOrientationEnum;
import domain.model.lib.BoardDimension;
import domain.model.lib.Position;

public class GameFacade {

	private BoardGame game;

	public GameFacade() {
		//TODO throws DomainException
		try {
			game = new BSGame();
		} catch (DomainException e) {
			e.printStackTrace();
		}
	}

	public BoardDimension getBoardSize() {
		return game.getBoardSize();
	}

	public BSGame getBoardGame(){
		return (BSGame) game;	
	}

	public void addPlayer(String name) throws DomainException{
		this.getBoardGame().addHuman(name);
	}

	public String getNameComputer() {
		return this.getBoardGame().getNameComputer();
	}

	public String getNameHuman() {
		return this.getBoardGame().getNameHuman();
	}
	
	public void addShip(Ship ship, Position position,ShipOrientationEnum orientation) {
		this.getBoardGame().addPion(ship, position,orientation);
	}
	
	public Board getBoard(){
		return game.getBoard();
	}
}
