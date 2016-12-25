package domain.model;

import java.util.ArrayList;
import java.util.List;


import domain.model.lib.Position;

/**
 * @author Thomas Vanzegbroeck & Brecht Decuyper
 */
public class NextPositionHitShipStrategy  implements HitShipStrategy {

	
	private List<Position> nothittedPostion = new ArrayList<Position>();
	
	public NextPositionHitShipStrategy(){
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
		if(nothittedPostion!=null && !nothittedPostion.isEmpty()){
			
			Position pos = this.nothittedPostion.get(0);
			this.nothittedPostion.remove(pos);
			return pos;				
		}
		return null;
	}

}
