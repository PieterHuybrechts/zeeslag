package domain.model;

import domain.DomainException;

public class Cell {

	private boolean hit;
	private Ship ship;
	
	public Cell(){
		hit = false;
		ship = null;
	}
	
	public void setShip(Ship ship){
		this.ship=ship;
	}
	
	public boolean isHit(){
		return this.hit;
	}
	
	public boolean isShip(){
		return this.ship!=null;
	}
	
	public boolean isSunken(){
		return ship.isSunken();
	}
	
	public boolean hit() throws DomainException{
		if(hit){
			throw new DomainException("Positie is al geraakt.");
		}
		
		boolean b = false;
		
		if(!hit && this.ship!=null){
			ship.hit();
			b = true;
		}
		this.hit=true;
		return b;
	}
	
	
	
}
