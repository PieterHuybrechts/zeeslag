package domain.service;

import java.awt.Dimension;

public class GameFacade {

	private BoardGame game;

	public GameFacade() {
		//TODO throws DomainException
		game = new BattleShipGame();
	}

	public Dimension getBoardSize() {
		return game.getBoardSize();
	}

	public BattleShipGame getBoardGame(){
		return (BattleShipGame) game;	
	}

	public void addPlayer(String name){
		this.getBoardGame().addHuman(name);
	}
}
