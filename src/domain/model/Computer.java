package domain.model;

import domain.DomainException;
import domain.model.factory.HitShipFactory;
import domain.model.factory.PlaceShipFactory;
import domain.model.lib.Position;

public class Computer extends Player{
	
	PlaceShipStrategy strat;
	HitShipStrategy hitStrat;
	public Computer(String name) throws DomainException{
		super(name,new BSBoard());
		strat = new PlaceShipFactory().getPlaceShipStrategy();
		hitStrat = new HitShipFactory().getHitShipStrategy();
		createShips();
	}
	
	private void createShips(){
		for(int i=0;i<5;i++){
			Ship ship= strat.createShip(getBoard());
			addShip(ship);
		}
	}
	public void hit(Player human){
		Position pos = hitStrat.hitShip();
		try {
			human.hit(pos);
		} catch (DomainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
