/******************************************************************************
 *  Compilation:  javac Alive.java
 *  Execution:    N/A
 *  Dependencies: Cell.java
 *
 *  Subclass of Cell.java that provides implementation on how it 
 *  should be shown on the board and change its state.
 *
 ******************************************************************************/

import java.util.ArrayList;

public class Alive extends Cell {

	public Alive(int x, int y) {
		super(x, y);
		state = "Alive";
	}
	
	// O(1)
	// pre: int 0 <= x,y < size of board
	// post: square with bottom left corner at (x,y)
	public void draw(int x, int y) {
		double[] xs = {x, x + 1.0, x + 1.0, x};
		double[] yx = {y, y, y + 1.0, y + 1.0};
		StdDraw.polygon(xs, yx);
	}

	// O(1)
	// pre: board with Cells instantiated
	// post: whether or not this Cell should change its state
	//       based on the states of its neighbors (including diagonals)
	public boolean checkChange(ArrayList<ArrayList<Cell>> board) {
                int x = this.getxCor();
                int y = this.getyCor();
                int count = 0;
                for (int[] offset : NEIGHBORS) {
                        if (Life.getTile(x + offset[0], y + offset[1]).toString().equals("Alive")) {
                                count++;
                        }
                }
//		System.out.println("count for " + x + "," + y + " " + count);
                if (count < 2 || count > 3) return true;
                return false;
        }

	// O(1)
	// pre: board instantiated with Cells
	// post: replace this Cell with another one with opposite state
	public void changeState(ArrayList<ArrayList<Cell>> board) {
                  int x = this.getxCor();
                  int y = this.getyCor();
                  board.get(x).set(y, new Dead(x, y));
        }

	
	// O(1)
	// pre: this Alive is instantiated
	// post: row number of this Cell in the board
	public int getxCor() {
		return xCor;
	}
	
	// O(1)
	// pre: this Alive Cell is instantiated
	// post: column number of this Cell in the board
	public int getyCor() {
		return yCor;
	}

	// O(1)
	// pre: this Alive Cell is instantiated
	// post: "Alive"
	public String toString() {
		return state;
	}

}
