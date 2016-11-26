package ui.controller;

import java.awt.Dimension;

import domain.DomainException;
import domain.service.GameFacade;

public class Controller {

	private GameFacade facade;
	
	public Controller() throws DomainException{
		facade = new GameFacade();
	}

	public Dimension getBoardSize() {
		return facade.getBoardSize();
	}

	public void addPlayer(String name) throws DomainException{
		this.facade.addPlayer(name);
	}

	public String getNameComputer() {
		return facade.getNameComputer();
	}

	public String getNameHuman() {
		return facade.getNameHuman();
	}
}
