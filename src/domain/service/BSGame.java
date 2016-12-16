package domain.service;

import java.util.ArrayList;
import java.util.List;

import common.Observer;
import domain.DomainException;
import domain.model.Board;
import domain.model.Computer;
import domain.model.GameState;
import domain.model.Human;
import domain.model.NewState;
import domain.model.Player;
import domain.model.Ship;
import domain.model.ShipEnum;
import domain.model.ShipOrientationEnum;
import domain.model.StartedState;
import domain.model.lib.BoardDimension;
import domain.model.lib.Position;

public class BSGame implements BoardGame{

	private final List<Observer> observers = new ArrayList<Observer>();
	
	private GameState newState = new NewState(this);
	private GameState startedState = new StartedState(this);
	private GameState currentState= newState;
	
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
	public void start() {
		if(this.human.getBSBoard().getShips().size() != 5){
			throw new IllegalArgumentException(">>>>>>>>>>>>>>>>nog geen 5 schepen hoezeee<<<<<<<<<<<<<<");
		} else{
			this.currentState.start();
		}
	}

	public void addHuman(String name) throws DomainException {
		this.human = new Human(name);
	}

	@Override
	public void addPion(Ship ship) {
	
		try {
			this.human.addShip(ship);
			notifyObservers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Board getBoard() {
		return human.getBoard();
	}

	@Override
	public void addObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		observers.forEach(o -> o.update());
	}

	public boolean isValidMove(ShipEnum type, ShipOrientationEnum orientation, Position pos) {
		return human.getBoard().isValidMove(type,orientation,pos);
		
	}
	
	public Player getHuman(){
		return this.human;
	}
	
	public Player getComputer(){
		return this.computer;
	}

	@Override
	public void setState(GameState state) {
		this.currentState = state;
		System.out.println(currentState.toString());
	}

	@Override
	public void newGame() {
		this.currentState.start();
	}

	@Override
	public GameState getStartedState() {
		return this.startedState;
	}

	@Override
	public GameState getNewSate() {
		return this.newState;
	}

	@Override
	public boolean isStarted() {	
		return this.currentState.equals(startedState);
	}

	@Override
	public void hit(Position pos) {	
		computer.getBoard().hit(pos);
		Computer c = (Computer) computer;
		c.hit(human.getBoard());;
		notifyObservers();
	}
}
