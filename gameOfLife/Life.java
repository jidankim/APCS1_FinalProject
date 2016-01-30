/******************************************************************************
 *  Compilation:  javac Life.java
 *  Execution:    java Life N
 *  Dependencies: StdDraw.java Cell.java Alive.java Dead.java
 *
 *  Every second, updates a board of size N * N of Alive and Dead 
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
//		System.out.println(board);
		randomize(); // initialize with random Alive and Dead Cells	
		StdDraw.setXscale(-1, size + 1);
		StdDraw.setYscale(-1, size + 1);
//		System.out.println(board);
		draw();
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

	public static Cell getTile(int x, int y) {
		if (x >= 0 && y >= 0 && x < size && y < size)
			return board.get(x).get(y);
		return new Dead(0,0);
	}

}
