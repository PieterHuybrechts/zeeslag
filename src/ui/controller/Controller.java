package ui.controller;

import java.awt.Dimension;

import domain.DomainException;
import domain.service.BattleShipGame;
import domain.service.BoardGame;

public class Controller {

	private BoardGame game;
	
	public Controller() throws DomainException{
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
