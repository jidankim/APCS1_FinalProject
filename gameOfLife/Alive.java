/******************************************************************************
 *  Compilation:  javac Alive.java
 *  Execution:    N/A
 *  Dependencies: Cell.java
 *
 *  Subclass of Cell.java that provides implementation on how it 
 *  should be shown on the board and change its state.
 *
 ******************************************************************************/


public class Alive extends Cell {

	public Alive(int x, int y) {
		super(x, y);
		state = "Alive";
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