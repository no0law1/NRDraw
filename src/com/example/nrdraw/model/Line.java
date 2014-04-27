package com.example.nrdraw.model;

import java.util.LinkedList;

/**
 * Class whose instance represents an Line
 * 
 * Line is composed by a set of points
 * 
 * @author rcacheira & nreis
 *
 */
public class Line {
	/**
	 * The Line's set of points
	 */
	private LinkedList<Point> points;
	
	/**
	 * Initiates an instance with the given first point
	 * @param firsPoint
	 */
	public Line(Point firsPoint){
		points = new LinkedList<Point>();
		points.add(firsPoint);
	}
	
	/**
	 * Adds a point to Line
	 * 
	 * @param p Point to add
	 */
	public void add(Point p) {
		points.add(p);
	}
	
	/**
	 * Gets the Line number of Points
	 * 
	 * @return the instance number of Points
	 */
	public int getNrOfPoints(){
		return points.size();
	}
	
	/**
	 * Gets the Line first point
	 * 
	 * It's useful when line has only one point
	 * 
	 * @return the instance list first point
	 */
	public Point getFirstPoint(){
		return points.getFirst();
	}
	
	/**
	 * Gets the Line set of points
	 * 
	 * @return the instance iterable list of points
	 */
	public Iterable<Point> getPoints(){
		return points;
	}
}
