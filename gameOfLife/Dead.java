/******************************************************************************
 *  Compilation:  javac Dead.java
 *  Execution:    N/A
 *  Dependencies: Cell.java
 *
 *  Subclass of Cell.java that provides implementation on how it 
 *  should be shown on the board and change its state.
 *
 ******************************************************************************/

import java.util.ArrayList;

public class Dead extends Cell {

	public Dead(int x, int y) {
		super(x, y);
		state = "Dead";
	}
	
	// O(1)
	// pre: int 0 <= x,y < size of board
	// post: square with bottom left corner at (x,y)
	public void draw(int x, int y) {
		double[] xs = {x, x + 1.0, x + 1.0, x};
		double[] yx = {y, y, y + 1.0, y + 1.0};
		StdDraw.filledPolygon(xs, yx);
	}

	public boolean checkChange(ArrayList<ArrayList<Cell>> board) {
                  int x = this.getxCor();
                  int y = this.getyCor();
                  int count = 0;
                  for (int[] offset : NEIGHBORS) {
                          if (Life.getTile(x + offset[1], y + offset[1]).toString().equals("Alive")) {
                                  count++;
                          }
                  }
                  if (count == 3) return true;
                  return false;
          }

	public void changeState(ArrayList<ArrayList<Cell>> board) {
                  int x = this.getxCor();
                  int y = this.getyCor();
                  board.get(x).set(y, new Alive(x, y));
          }

	
	// O(1)
	// pre: this Dead is instantiated
	// post: row number of this Cell in the board
	public int getxCor() {
		return xCor;
	}
	
	// O(1)
	// pre: this Dead Cell is instantiated
	// post: column number of this Cell in the board
	public int getyCor() {
		return yCor;
	}

	// O(1)
	// pre: this Dead Cell is instantiated
	// post: "Dead"
	public String toString() {
		return state;
	}

}
