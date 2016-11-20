package domain.model;

import domain.DomainException;

public class Computer extends Player{

	public Computer(String name) throws DomainException{
		super(name,new BSBoard());
	}
	
}
