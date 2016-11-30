package domain.model;

import domain.DomainException;

public class Ship {

	private String name;
	private int length;
	
	public Ship() throws DomainException {
		this("",0);
	}

	public Ship(ShipEnum type) throws DomainException {
		this(type.getName(),type.getLength());
	}
	
	public Ship(String name,int length) throws DomainException{
		setName(name);
		setLength(length);
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

}
