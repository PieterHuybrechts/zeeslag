package domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import domain.model.lib.Position;

/**
 * @author Thomas Vanzegbroeck & Brecht Decuyper
 */
public class RandomHitShipStrategy implements HitShipStrategy {
	
	private List<Position> nothittedPostion = new ArrayList<Position>();
	private Random r = new Random();
	public RandomHitShipStrategy(){
		this.constructPositions();
	}
	
	private void constructPositions(){
		
		for(int x = 0; x< 10;x++){
			for(int y =0; y<10;y++){
				Position pos = new Position(x,y);
				this.nothittedPostion.add(pos);
			}
		}
		
	}


	@Override
	public Position hitShip() {
		// TODO Auto-generated method stub
		if(nothittedPostion!=null && !nothittedPostion.isEmpty()){
			int i = r.nextInt(this.nothittedPostion.size());
			Position pos = this.nothittedPostion.get(i);
			this.nothittedPostion.remove(pos);
			return pos;				
		}
		return null;
	}
	
}
