package com.phc.drawgrid;

import com.phc.life.Neighbors;

import android.os.AsyncTask;
import android.util.Log;

/* 
 * A background task for the game of life. 
 * This game engine runs on a background thread. 
 * This task is passed an instance of the view. 
 * It calls method on the view to provide 
 * each subsequent generation to teh view
 * 
 */

/* Params, Progress, Result */
public class LifeAsyncTask extends AsyncTask<LifeParams, char[][], Object> {

	private boolean quit = false; 
	private boolean run = false; 
	private LifeParams lifeParams; 
	private final String TAG = "DrawGridLife"; 
	private MyGridView myGridView; 
	private int genCount = 0; 
	private int nrow;  
	private int ncol; 
	private char [][] generation; 
	private char[][] nextGeneration;  
	
	public LifeAsyncTask(LifeParams lp) {
		this.lifeParams = lp;
	}
	
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		myGridView = lifeParams.getGridView(); 
		nrow = lifeParams.getNumRows(); 
		ncol = lifeParams.getNumCols(); 
		generation = myGridView.getCurrentGeneration(); 
		this.nextGeneration = new char[nrow][ncol]; 
		Log.v(TAG, " onPreExecute(): nextGeneration.length:"+nextGeneration.length); 
		Log.v(TAG, " onPreExecute(): nextGeneration[0].length:"+nextGeneration[0].length); 
	}
	
	/* the game of life engine is performed in this method */
	@Override
	protected Object doInBackground(LifeParams... lp) {
		int numNeighbors = 0; 
		//main loop 
		while(!quit) {
			while(run && !quit) {
				//do the life rules
				//populate the grid
				for(int r = 0; r < nrow; r++)
				{
					for(int c = 0; c< ncol; c++)
					{
						numNeighbors = Neighbors.getNeighbors(this.generation, r, c); 
						
						 //if dead space
						  if(this.generation[r][c] != '*')
						  {
						    //and if 3 neighbors, populate new world or stay dead
							if(numNeighbors == 3)
							  this.nextGeneration[r][c] = '*';
							else
								this.nextGeneration[r][c]= ' '; 	//phc 
						  }
						  else
						  {
						    //else if live, check for death and populate new world
							if(numNeighbors < 2 || numNeighbors > 3)
							  this.nextGeneration[r][c] = ' ';
							else
							  this.nextGeneration[r][c] = '*';
						  }	
					}
				}
				//sleep between generations
				try {
					Thread.sleep(lifeParams.getGenTime());
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				
				//update the generation count
				genCount++; 
				myGridView.setGenCount(genCount); 
				
				//refresh the view , setup for next gen
				this. myGridView.setGeneration(this.nextGeneration); 
				
				//transfer next generation to current generation for next pass
				this.transferGeneration(); 
				this.initNextGeneration(); 
				this.myGridView.postInvalidate(); 
			} //run
			
			// instead of invoking methods on the view. could call 
			// publish progress with results 
			// publishProgress(null); 
		} //quit
		
		Log.v(TAG, " doInBackGround : quitting"); 
		return null;
	}	
	
	
	@Override
	protected void onProgressUpdate(char[][]... values) {
		// TODO Auto-generated method stub
		super.onProgressUpdate(values);
	}
	
	/* causes game to run or pause */
	public void setRun(boolean run) {
		this.run = run;
	}
	
	/* end the game */
	public void setQuit(boolean quit) {
		this.quit = quit; 
		Log.v(TAG, "LifeAsyncTask setQuit to: "+quit); 
	}
	
	/* initialize the game of life grid */
	private void initNextGeneration() {
		for  (int r =0;  r < nrow; r++)
			for(int c =0; c < ncol; c++)
				this.nextGeneration[r][c] = ' '; 
				
	}
	
	//transfer nextGen to current gen
	private void transferGeneration() {
		for  (int r =0;  r < nrow; r++)
			for(int c =0; c < ncol; c++)
				this.nextGeneration[r][c] = generation[r][c]; 
	}
	
} ///~
