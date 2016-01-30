import java.util.ArrayList;

public class Life {

	private static ArrayList<ArrayList<Cell>> board;
	private static int size;

	public static void main(String[] args) {
		size = Integer.parseInt(args[0]);
		board = new ArrayList<ArrayList<Cell>>(size);
		System.out.println(board);
		randomize(); // initialize with random Alive and Dead Cells	
		System.out.println(board);
	}

	public static void randomize() {	
		// first initialize all Cells with Alive
		// and make them into Dead randomly
		for (int i = 0; i < size; i++) {
			board.add(new ArrayList<Cell>());
			for (int j = 0; j < size; j++) {
				board.get(i).add(new Alive(i, j));
			}
		}

		// here we randomly set some Cells to Dead
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

}
