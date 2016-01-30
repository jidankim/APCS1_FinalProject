/******************************************************************************
 *  Compilation:  javac Life.java
 *  Execution:    java Life N
 *  Dependencies: StdDraw.java Cell.java Alive.java Dead.java
 *
 *  Initializes a random board of Alive and Dead Cells. 
 *  Every 0.5 seconds, updates a board of size N * N of Alive and Dead 
 *  Cells according to Conway’s rule on Game of Life.
 *
 *  % java Life 10
 *
 ******************************************************************************/


import java.util.ArrayList;

public class Life {

	private static ArrayList<ArrayList<Cell>> board;
	private static int size;

	public static void main(String[] args) {
		size = Integer.parseInt(args[0]);
		board = new ArrayList<ArrayList<Cell>>(size);
		randomize(); // initialize with random Alive and Dead Cells	
		StdDraw.setXscale(-1, size + 1);
		StdDraw.setYscale(-1, size + 1);
		
		while (true) {
			StdDraw.clear(StdDraw.WHITE);
			for (ArrayList<Cell> row : board) {
				for (Cell curr : row) {
					if (curr.checkChange(board)) {
						curr.changeState(board);
					}
				}
			}
			draw();
			StdDraw.show(500);
		}
	}
	
	// O(N^2)
	// pre: static variable board should have been declared and 
	//      initialized
	// post: static variable board filled with Alive and Dead
	//       Cells at random
	public static void randomize() {
	
		// first initialize all Cells with Alive
		for (int i = 0; i < size; i++) {
			board.add(new ArrayList<Cell>());
			for (int j = 0; j < size; j++) {
				board.get(i).add(new Alive(i, j));
			}
		}

		// then we randomly set some Cells to Dead
		int i = 0, j = 0;
		for (ArrayList<Cell> row : board) {
			for (Cell curr : row) {
				double r = Math.random();
				if (r >= 0.5) {
					board.get(i).set(j, new Dead(i, j));
				}
				j++;
			}
			j = 0;
			i++;
		}
	}

	// O(N^2)
	// pre: static variable board should have been declared and 
	//      initialized
	// post: goes through and draws each Cell
	public static void draw() {
		int i = 0, j = 0;
		for (ArrayList<Cell> row : board) {
			for (Cell curr : row) {
				curr.draw(i, j);
				j++;
			}
			j = 0;
			i++;
		}
	}

	// O(1)
	// pre: static variable board should have been declared and 
	//      initialized
	// post: return Cell at position (x,y)
	//       if not in board, returns a Dead Cell at (0,0)
	//       because this function is used for counting Alive Cells
	//       in the neighborhood and will effectively be null	
	public static Cell getTile(int x, int y) {
		if (x >= 0 && y >= 0 && x < size && y < size)
			return board.get(x).get(y);
		return new Dead(-1,-1);
	}

}
