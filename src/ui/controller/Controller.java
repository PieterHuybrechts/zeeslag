package ui.controller;

import domain.DomainException;
import domain.model.Ship;
import domain.model.ShipEnum;
import domain.model.lib.BoardDimension;
import domain.model.lib.Position;
import domain.service.GameFacade;

public class Controller {

	private GameFacade facade;
	
	public Controller() throws DomainException{
		facade = new GameFacade();
	}

	

	/*************************
	 *    ADD INFORMATION    *
	 *************************/


	public void addPlayer(String name) throws DomainException{
		this.facade.addPlayer(name);
	}

	public void addShip(ShipEnum type, Position position) {
		this.facade.addShip(new Ship(type), position);
	}
	

	/*************************
	 *    GET INFORMATION    *
	 *************************/


	public BoardDimension getBoardSize() {
		return facade.getBoardSize();
	}

	public String getNameComputer() {
		return facade.getNameComputer();
	}

	public String getNameHuman() {
		return facade.getNameHuman();
	}
}
