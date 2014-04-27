package com.example.nrdraw.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Class whose instance represents a drawing
 * 
 * A Drawing is represented by a set of lines
 * 
 * @author rcacheira & nreis
 *
 */
public class Drawing {
	/**
	 * The Drawing's set of lines
	 */
	private List<Line> lines;
	
	/**
	 * Initiates an instance without lines
	 */
	public Drawing() {
		lines = new LinkedList<Line>();
	}
	
	/**
	 * Adds a line to Drawing
	 * 
	 * @param l Line to add
	 */
	public void add(Line l){
		lines.add(l);
	}
	
	/**
	 * Get's the Drawing number of lines
	 * 
	 * @return the instance number of lines
	 */
	public int getNrOfLines(){
		return lines.size();
	}

	/**
	 * Get's the Drawing set of lines
	 * 
	 * @return the instance iterable list of lines 
	 */
	public Iterable<Line> getLines(){
		return lines;
	}
}
