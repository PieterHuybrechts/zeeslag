package domain.service;

import domain.DomainException;
import domain.model.BSBoard;
import domain.model.Board;
import domain.model.Player;
import domain.model.Ship;
import domain.model.ShipEnum;
import domain.model.ShipOrientationEnum;
import domain.model.lib.BoardDimension;
import domain.model.lib.Position;
import domain.model.observer.Observer;
import domain.model.state.GameState;

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

	public void restartGame() {
		// TODO Auto-generated method stub
		
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
	
	public Board getBoard(Boolean isHuman){
		return game.getBoard(isHuman);
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

	public Player getWinner() {
		// TODO Auto-generated method stub
		return game.getWinner();
	}


}
