package com.phc.life;

//**************************************************
// File Name: Neighbors.java
//
// Purpose: Neighbors check for the Game of Life
//
//**************************************************

public class Neighbors
{
  public static int getNeighbors(char[][] w, int r, int c)
  {
    int rowmin, rowmax, colmin, colmax, neighbors;

    //Check for edge and set boundary threshold
    if(LifeUtils.isTopEdge(r, c))
        rowmin = r;
    else
        rowmin = r-1;

    if(LifeUtils.isBottomEdge(r, w))
        rowmax = r;
    else
        rowmax = r+1;

    if(LifeUtils.isLeftEdge(c))
	  colmin = c;
    else
	  colmin = c-1;

    if(LifeUtils.isRightEdge(c, w))
	  colmax = c;
    else
	  colmax = c+1;

	neighbors = 0;
	//Check each boundary for neighbors
	for(int row = rowmin; row <= rowmax; row++)
	{
	  for(int col = colmin; col <= colmax; col++)
	  {
	    //if not current cell being checked
		if(row != r || col != c)
		{
		  //if boundary is populated, increment counter
		  if(w[row][col] == '*')
		    neighbors++;
		}
	  }
	}
	return neighbors;
  }//end getNeighbors
}//end class
