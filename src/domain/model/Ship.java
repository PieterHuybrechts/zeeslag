package domain.model;

import java.util.ArrayList;
import java.util.List;

import domain.DomainException;
import domain.model.lib.Position;
import domain.model.observer.Observer;
import domain.model.observer.Subject;

/**
 * @author Pieter Huybrechts & Brecht Decuyper
 */
public class Ship implements Subject{

	private String name;
	private int length;
	private Position pos;
	private ShipOrientationEnum orientation;
	private int lives;
	
	private List<Observer> observers;
	
	public Ship() throws DomainException {
		this("",0);
		
	}

	public Ship(ShipEnum type) throws DomainException {
		this(type.getName(),type.getLength());
	}
	public Ship(ShipEnum type,Position pos, ShipOrientationEnum or) throws DomainException {
		this(type.getName(),type.getLength());
		this.setPos(pos);
		this.setOrientation(or);
	}
	public Ship(String name,int length) throws DomainException{
		setName(name);
		setLength(length);
		setLives(length);
		observers = new ArrayList<Observer>();
	}
	public Ship(String name,int length,Position pos, ShipOrientationEnum or) throws DomainException{
		setName(name);
		setLength(length);
		this.setPos(pos);
		this.setOrientation(or);
		setLives(length);
		observers = new ArrayList<Observer>();
	}
	
	private void setLives(int lives) throws DomainException {
		if(lives<1){
			throw new DomainException("A ship can't be smaller than 1");
		}
		
		this.lives = lives;
	}

	private void setName(String name) throws DomainException{
		if(name == null || name.isEmpty()){
			throw new DomainException("A shipname can't be empty");
		}
		
		this.name = name;
	}
	
	private void setLength(int length) throws DomainException{
		if(length<1){
			throw new DomainException("A ship can't be smaller than 1");
		}
		
		this.length = length;
	}
	
	public String getName(){
		return name;
	}
	
	public int getLength(){
		return length;
	}

	public ShipOrientationEnum getOrientation() {
		return orientation;
	}

	public void setOrientation(ShipOrientationEnum orientation) {
		this.orientation = orientation;
	}

	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}

	public void hit() {
		lives--;	
		
		if(isSunken()){
			notifyObservers();
		}
		
	}
	
	public boolean isSunken(){
		return lives<=0;
	}

	@Override
	public void addObserver(Observer o) {
		observers.add(o);		
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		observers.forEach(o -> o.update());
	}

}
