package ui.controller;

import java.awt.Dimension;

import domain.DomainException;
import domain.service.BattleShip;
import domain.service.BoardGame;

public class Controller {

	private BoardGame game;
	
	public Controller() throws DomainException{
		game = new BattleShip();
	}

	public Dimension getBoardSize() {
		return game.getBoardSize();
	}
}