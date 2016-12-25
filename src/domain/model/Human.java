package domain.model;

import domain.DomainException;

/**
 * @author Thomas Vanzegbroeck
 */
public class Human extends Player{

	public Human(String name) throws DomainException{
		super(name,new BSBoard());
	}
}
