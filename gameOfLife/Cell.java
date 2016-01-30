/******************************************************************************
 *  Compilation:  javac Cell.java
 *  Execution:    N/A
 *  Dependencies: N/A
 *
 *  Abstract superclass for Alive and Dead Cells to be placed in the board.
 *
 ******************************************************************************/

import java.util.ArrayList;

public abstract class Cell {

	protected int xCor;
	protected int yCor;
	protected String state;
	protected static final int[][] NEIGHBORS = {
              {-1, +1}, {0, +1}, {+1, +1},
              {-1,  0},          {+1,  0},
              {-1, -1}, {0, -1}, {+1, -1}};

	public Cell(int x, int y) {
		xCor = x;
		yCor = y;
		state = "";
	}

	public abstract void draw(int x, int y);
	public abstract boolean checkChange(ArrayList<ArrayList<Cell>> b);
	public abstract void changeState(ArrayList<ArrayList<Cell>> b);
	public abstract int getxCor();
	public abstract int getyCor();
	public abstract String toString();
}
