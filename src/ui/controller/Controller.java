package ui.controller;

import domain.DomainException;
import domain.model.Board;
import domain.model.Ship;
import domain.model.ShipEnum;
import domain.model.ShipOrientationEnum;
import domain.model.lib.BoardDimension;
import domain.model.lib.Position;
import domain.service.GameFacade;
import ui.view.View;

public class Controller {

	private GameFacade facade;
	private View view;
	
	public Controller() throws DomainException{
		this.view = new View(this);
		facade = new GameFacade();
	}

	public void start() {
		view.startNameEntryView();
		view.startGameView();
	}

	/*************************
	 *    ADD INFORMATION    *
	 *************************/


	public void addPlayer(String name) throws DomainException{
		this.facade.addPlayer(name);
	}

	public void addShip(ShipEnum type, Position position, ShipOrientationEnum orientation) throws DomainException {
	
		this.facade.addShip(new Ship(type,position, orientation), position, orientation);
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

	public Board getBoard(){
		return facade.getBoard();
	}

}
