package com.phc.drawgrid;

/* 
 * A demonstrative class for holding parameters associated with 
 * the game of life
 */
public class LifeParams {
	
	private MyGridView gridView; 
	private int nrow, ncol = 0; 
	private int genTime = 500;
	private String pattern;  
	
	public LifeParams(MyGridView gv, int nrow, int ncol, int genTime, String pattern) {
		this.gridView = gv; 
		this.nrow = nrow; 
		this.ncol = ncol; 
		this.genTime = genTime; 
		this.pattern = pattern;
	}
	
	/***********/
	/* getters */
	/***********/
	public MyGridView getGridView() {
		return this.gridView; 
	}
	
	public int getNumRows() {
		return this.nrow; 
	}
	
	public int getNumCols() {
		return this.ncol; 
	}	
	
	public int getGenTime() {
		return this.genTime; 
	}
	
	public String getPattern() {
		return this.pattern; 
	}
} ///~
