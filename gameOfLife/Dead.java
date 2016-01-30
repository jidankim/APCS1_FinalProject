/******************************************************************************
 *  Compilation:  javac Dead.java
 *  Execution:    N/A
 *  Dependencies: Cell.java
 *
 *  Subclass of Cell.java that provides implementation on how it 
 *  should be shown on the board and change its state.
 *
 ******************************************************************************/


public class Dead extends Cell {

	public Dead(int x, int y) {
		super(x, y);
		state = "Dead";
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
