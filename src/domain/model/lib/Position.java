package domain.model.lib;

/**
 * @author Brecht Decuyper
 */
public class Position {
	
	private int x, y;

	/**
	 * Constructs and initializes a position at the origin (0,0)
	 * of the coordinate space.
	 */
	public Position() {
		this.setLocation(0, 0);
	}

	/**
	 * Constructs and initializes a position at the specified (x,y)
	 * location in the coordinate space.
	 * 
	 * @param x: the X coordinate of the newly constructed Position.
	 * @param y: the Y coordinate of the newly constructed Position.
	 */
	public Position(int x, int y) {
		this.setLocation(x, y);
	}

	/**
	 * Constructs and initializes a position with the same location
	 * as the specified Position object.
	 * 
	 * @param p: a point.
	 */
	public Position(Position p) {
		this.setLocation(p);
	}

	/**
	 * Determines whether or not two positions are equal.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Position) {
			Position position = (Position) obj;
			return (position.getX() == this.getX() &&
					position.getY() == this.getY());			
		}
		return false;
	}

	/**
	 * Returns the location of this position.
	 * 
	 * @return this point.
	 */
	public Position getLocation() {
		return this;
	}

	/**
	 * Returns the X coordinate of this position.
	 * 
	 * @return the X coordinate of this position.
	 */
	public int getX() {
		return x;
	}

	/**
	 * Returns the Y coordinate of this position.
	 * 
	 * @return the Y coordinate of this position.
	 */
	public int getY() {
		return y;
	}

	/**
	 * Moves this position to the specified location in the (x,y)
	 * coordinate plane.
	 * 
	 * @param x: an integer, the new X coordinate for this position.
	 * @param y: an integer, the new Y coordinate for this position.
	 */
	public void move(int x, int y) {
		this.setLocation(x, y);
	}

	/**
	 * Returns a string representation of the location of this
	 * position in the (x,y) coordinate space.
	 */
	@Override
	public String toString() {
		return "(" + this.getX() + "," + this.getY() + ")";
	}

	/**
	 * Translates this position, at location (x,y), by dx along the
	 * x axis and dy along the y axis so that it now represents
	 * the position (x+dx,y+dy).
	 * 
	 * @param dx: the distance to move this position along the X axis.
	 * @param dy: the distance to move this position along the Y axis.
	 */
	public void translate(int dx, int dy) {
		this.setX(this.getX() + dx);
		this.setY(this.getY() + dy);
	}

	/**
	 * Changes the position to have the specified location.
	 * 
	 * @param x: an integer, the new X coordinate for this position.
	 * @param y: an integer, the new Y coordinate for this position.
	 */
	private void setLocation(int x, int y) {
		setX(x);
		setY(y);
	}

	/**
	 * Sets the location of this position to the specified location.
	 * 
	 * @param p: a position, the new location for this position.
	 */
	private void setLocation(Position p) {
		setX(p.getX());
		setY(p.getY());
	}

	/**
	 * Sets the X coordinate of this position to the specified integer.
	 * 
	 * @param x: an integer, the new X coordinate of this position.
	 */
	private void setX(int x) {
		this.x = x;
	}

	/**
	 * Sets the Y coordinate of this position to the specified integer.
	 * 
	 * @param y: an integer, the new Y coordinate of this position.
	 */
	private void setY(int y) {
		this.y = y;
	}
}
