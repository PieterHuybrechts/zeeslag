package domain.model.lib;

public class BoardDimension {

	private int height, width;

	/**
	 * Constructs and initializes a boardDimension with a size of (0,0).
	 */
	public BoardDimension() {
		this.setSize(0, 0);
	}

	/**
	 * Constructs and initializes a boardDimension with the
	 * specified (width,height) size.
	 * 
	 * @param width: the width of the newly constructed BoardDimension.
	 * @param height: the height of the newly constructed BoardDimension.
	 */
	public BoardDimension(int width, int height) {
		this.setSize(width, height);
	}

	/**
	 * Constructs and initializes a boardDimension with the same size
	 * as the specified BoardDimension object.
	 * 
	 * @param d: a boardDimension.
	 */
	public BoardDimension(BoardDimension d) {
		this.setSize(d);
	}

	/**
	 * Returns the size of this boardDimension.
	 * 
	 * @return this boardDimension.
	 */
	public BoardDimension getSize() {
		return this;
	}

	/**
	 * Returns the height of this boardDimension.
	 * 
	 * @return the height of this boardDimension.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Returns the width of this boardDimension.
	 * 
	 * @return the width of this boardDimension.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Determines whether or not two boardDimension are equal.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof BoardDimension) {
			BoardDimension dimension = (BoardDimension) obj;
			return (dimension.getWidth() == this.getWidth() &&
					dimension.getHeight() == this.getHeight());			
		}
		return false;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "(" + this.getWidth() + "," + this.getHeight() + ")";
	}

	/**
	 * Sets the boardDimension to the specified size.
	 * 
	 * @param width: an integer, the new width for this boardDimension.
	 * @param height: an integer, the new height for this boardDimension.
	 */
	private void setSize(int width, int height) {
		this.setWidth(width);
		this.setHeight(height);
	}

	/**
	 * Sets the size of this dimension to the specified size.
	 * 
	 * @param d: a boardDimension, the new size for this boardDimension.
	 */
	private void setSize(BoardDimension d) {
		this.setWidth(d.getWidth());
		this.setHeight(d.getHeight());
	}

	/**
	 * Sets the height of this boardDimension to the specified integer.
	 * 
	 * @param height: an integer, the new height of this boardDimension.
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Sets the width of this boardDimension to the specified integer.
	 * @param width: an integer, the new width of this boardDimension.
	 */
	public void setWidth(int width) {
		this.width = width;
	}	
}
