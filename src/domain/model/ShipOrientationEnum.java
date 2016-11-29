package domain.model;

public enum ShipOrientationEnum {

	HORIZONTAL("Horizontaal"),
	VERTICAL("Verticaal");
	
	private String description;
	
	private ShipOrientationEnum(String description){
		this.description = description;
	}
	
	public String toString(){
		return this.description;
	}
}
