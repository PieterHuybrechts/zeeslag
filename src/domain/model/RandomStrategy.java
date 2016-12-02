package domain.model;

import java.util.Random;

import domain.DomainException;
import domain.model.lib.Position;

public class RandomStrategy implements PlaceShipStrategy{

	@Override
	public Ship createShip(Board board) {
		Ship ship = null;
		
		while(true){
			Random r = new Random();
			
			
			
			int x = r.nextInt(board.getSize().getWidth());
			int y = r.nextInt(board.getSize().getHeight());
			Position pos = new Position(x,y);
			ShipEnum type = ShipEnum.values()[r.nextInt(ShipEnum.values().length)];
			ShipOrientationEnum or = ShipOrientationEnum.values()[r.nextInt(ShipOrientationEnum.values().length)];
			
			try {
				ship = new Ship(type, pos, or);
			} catch (DomainException e) {}

			//if(board.)
			
		}
		
		
		return ship;
	}

}
