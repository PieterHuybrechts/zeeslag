package domain.model;

import domain.DomainException;
import domain.model.lib.Position;

public abstract class Player {

	private String name;
	private Board board;
	private int score;
	
	public Player(String name,Board board) throws DomainException{
		setName(name);
		setBoard(board);
		score=19;
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
	
	public void addShip(Ship ship){
		this.getBSBoard().addShip(ship);
	}
	
	public void hit(Position pos) throws DomainException{
		if(getBoard().hit(pos)){
			score--;
		}
	}
	
	public int getScore(){
		return this.score;
	}
}

