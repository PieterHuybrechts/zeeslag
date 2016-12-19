package ui.controller;

import domain.DomainException;
import domain.model.BSBoard;
import domain.model.Board;
import domain.model.GameState;
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
		facade.addObserver(view);
	}

	public void start() {
		view.startNameEntryView();
		view.startGameView();
	}
	
	public void startGame(){
		facade.startGame();
	}
	
	public void restartGame(){
		facade = new GameFacade();
		facade.addObserver(view);
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
	
		this.facade.addShip(type, position, orientation);
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

	public boolean isValidMove(ShipEnum type, ShipOrientationEnum orientation, Position pos) {
		return facade.isValidMove(type,orientation,pos);
	}

	public BSBoard GetHumanBoard() {
		return facade.getHumandBoard();
		
	}

	public BSBoard getComputerBoard() {
		return facade.getComputerBoard();
		
	}

	public boolean isStarted() {
		return facade.isStarted();
		
	}

	public void hit(Position p) {
		facade.hit(p);
	}

	public int getHumanScore() {
		return facade.getHumanScore();
	}

	public int getComputerScore() {
		return facade.getComputerScore();
	}
	
	public GameState getGameState(){
		return facade.getGameState();
	}

	public void quit() {
		System.exit(1);
		
	}

}
