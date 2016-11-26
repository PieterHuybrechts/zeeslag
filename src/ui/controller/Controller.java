package ui.controller;

import java.awt.Dimension;

import domain.DomainException;
import domain.service.BattleShipGame;
import domain.service.GameFacade;

public class Controller {

	private GameFacade facade;
	
	public Controller() throws DomainException{
		facade = new GameFacade();
	}

	public Dimension getBoardSize() {
		return facade.getBoardSize();
	}

	public BattleShipGame getBoardGame(){
		return (BattleShipGame) facade.getBoardGame();	
	}

	public void addPlayer(String name) throws DomainException{
		this.getBoardGame().addHuman(name);
	}
}
