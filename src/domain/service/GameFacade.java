package domain.service;

import java.awt.Dimension;

import domain.DomainException;

public class GameFacade {

	private BoardGame game;

	public GameFacade() {
		//TODO throws DomainException
		try {
			game = new BattleShipGame();
		} catch (DomainException e) {
			e.printStackTrace();
		}
	}

	public Dimension getBoardSize() {
		return game.getBoardSize();
	}

	public BattleShipGame getBoardGame(){
		return (BattleShipGame) game;	
	}

	public void addPlayer(String name) throws DomainException{
		this.getBoardGame().addHuman(name);
	}
}
