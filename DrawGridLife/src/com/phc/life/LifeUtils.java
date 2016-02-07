package com.phc.life;
//**************************************************
// File Name: LifeUtils.java
//
// Purpose: Utility for the Game of Life
//          Update for droid
//
// Author: Paul Comitz
//**************************************************

public class LifeUtils
{
  public static boolean isEdge(char[][] w, int r, int c)
  {
	//it it in an edge ?
	if((r == 0) || (r == w.length-1) || (c == 0) || (c == w.length-1))
	  return true;
    else
	  return false;
  }

  public static boolean isTopEdge(int r, int c)
  {
    if(r == 0)
	  return true;
	else
	  return false;
  }

  public static boolean isBottomEdge(int r, char[][] w)
  {
    if(r == w.length-1)
	  return true;
	else
	  return false;
  }

  public static boolean isLeftEdge(int c)
  {
    if(c == 0)
	  return true;
	else
	  return false;
  }

  public static boolean isRightEdge(int c, char[][] w)
  {
    if(c == w.length-1)
	  return true;
	else
	  return false;
  }
}//class
