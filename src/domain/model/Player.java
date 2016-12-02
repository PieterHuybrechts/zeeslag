package domain.model;

import domain.DomainException;
import domain.model.lib.Position;

public abstract class Player {

	private String name;
	private Board board;
	
	public Player(String name,Board board) throws DomainException{
		setName(name);
		setBoard(board);
	}
	
	public String getName(){
		return this.name;
	}
	
	protected void setName(String name) throws DomainException{
		if(name == null || name.isEmpty()){
			throw new DomainException("Name can't be empty");
		}
		this.name = name;
	}
	
	public Board getBoard(){
		return this.board;
	}
	public BSBoard getBSBoard(){
		return (BSBoard) this.board;
	}
	protected void setBoard(Board board) throws DomainException{
		if(board==null){
			throw new DomainException();
		}
		
		this.board = board;
	}
	public abstract void addShip(Ship ship, Position position, ShipOrientationEnum orientation) throws DomainException, Exception;
}
