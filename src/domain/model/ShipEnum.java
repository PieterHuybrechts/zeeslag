package domain.model;

public enum ShipEnum {
	VLIEGDEKSCHIP ("Vliegdekschip", 5),
	SLAGSCHIP ("Slagschip", 4),
	ONDERZEEER ("Onderzeeër", 3),
	TORPEDOBOOTJAGER ("Torpedobootjager", 3),
	PATROUILLESHIP ("Patrouilleschip", 2);

	private String name;
	private int length;

	private ShipEnum(String name, int length) {
		this.name = name;
		this.length = length;
	}

	public String getName() {
		return this.name;
	}

	public int getLength() {
		return this.length;
	}
	
	public String toString(){
		return getName()+" ("+getLength()+")";
	}
}
