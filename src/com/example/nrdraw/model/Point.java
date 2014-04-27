package com.example.nrdraw.model;

/**
 * Class whose instance represents a Point
 * 
 * Point have a position, that is represented as a rectangular 
 * coordinates that must be positive values
 * 
 * @author rcacheira & nreis
 *
 */
public class Point{
	/**
	 * The Point's position
	 */
	private float x, y;
	
	/**
	 * Initiates an instance with the given coordinates
	 * 
	 * @param x The horizontal coordinate value
	 * @param y The Vertical coordinate value
	 */
	public Point(float x, float y) {
		if(x<0 || y<0) 
			throw new IllegalArgumentException();
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Gets the Point's horizontal coordinate value
	 * 
	 * @return The instance horizontal value
	 */
	public float getX() {
		return x;
	}
	
	/**
	 * Gets the Point's vertical coordinate value
	 * 
	 * @return The instance vertical value
	 */
	public float getY() {
		return y;
	}
	
	
}
