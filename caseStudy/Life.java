import java.util.ArrayList;

public class Life {

	private static ArrayList<ArrayList<Cell>> board;
	private static int N;

	public static void main(String[] args) {
		N = Integer.parseInt(args[0]);
		board = new ArrayList<ArrayList<Cell>>(N);
		System.out.println(board);
		random();
		System.out.println(board);

		StdDraw.setXscale(-1, N + 1);
		StdDraw.setYscale(-1, N + 1);
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
			StdDraw.show(1000);
		}
	}

	public static void random() {
		int i = 0, j = 0;
		for (ArrayList<Cell> row : board) {
			System.out.println(row);
			for (Cell curr : row) {
//				int x = curr.getxCor();
//				int y = curr.getyCor();
				int r = (int)Math.random();
				if (r >= 0.5) {
					board.get(i).add(new Alive(i, j));
				} else {
					board.get(i).add(new Dead(i, j));
				}
				j++;
			}
			System.out.println(row);
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
			i++;
		}
	}	

	public static Cell getTile(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < N)
			return board.get(x).get(y);
		return new Dead(0,0);
	}

}
