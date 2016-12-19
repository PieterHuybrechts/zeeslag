package domain.service;

import common.Observer;
import domain.DomainException;
import domain.model.BSBoard;
import domain.model.Board;
import domain.model.GameState;
import domain.model.Ship;
import domain.model.ShipEnum;
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
	
	public void addShip(ShipEnum ship, Position position,ShipOrientationEnum orientation) {
		try {
			this.getBoardGame().addPion(new Ship(ship,position,orientation));
		} catch (DomainException e) {
			e.printStackTrace();
		}
	}
	
	public Board getBoard(){
		return game.getBoard();
	}
	
	public void addObserver(Observer o){
		game.addObserver(o);
	}

	public boolean isValidMove(ShipEnum type, ShipOrientationEnum orientation, Position pos) {
		BSGame g = (BSGame) game;
		
		return g.isValidMove(type,orientation,pos);
	}
	
	public BSBoard getHumandBoard(){
		BSGame g = (BSGame) game;
		return (BSBoard) g.getHuman().getBoard();
	}
	
	public BSBoard getComputerBoard(){
		BSGame g = (BSGame) game;
		return (BSBoard) g.getComputer().getBoard();
	}

	public void startGame() {
		// TODO Auto-generated method stub
		this.game.start();
	}

	public boolean isStarted() {
		return game.isStarted();
	}

	public void hit(Position p) {
		game.hit(p);
	}

	public int getHumanScore() {
		return game.getHumanScore();
	}

	public int getComputerScore() {
		return game.getComputerScore();
	}
	
	public GameState getGameState(){
		return game.getCurrentState();
	}
}
