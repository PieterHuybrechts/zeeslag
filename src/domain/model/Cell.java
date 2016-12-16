package domain.model;

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
	
	public void hit(){
		if(!hit && this.ship!=null){
			ship.hit();
		}
		this.hit=true;
	}
	
	
	
}
