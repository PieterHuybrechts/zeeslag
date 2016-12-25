package domain.model;

/**
 * @author Thomas Vanzegbroeck & Pieter Huybrechts
 */
public interface PlaceShipStrategy {	
	public Ship createShip(Board board);
}
