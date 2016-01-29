import java.util.ArrayList;

public class Life {

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		Cell[] board = new Cell[N];
		for (int i = 0; i < N; i++) {
			board[i] = new ArrayList<Cell>();
		}		
		StdDraw.setXscale(-1, N);
		StdDraw.setYscale(-1. N);
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				if (checkChange(board[i].get(j)))
					board[i].get(j).changeState();
	}

	public static void change(Cell other) {
		int x = o(other.getXcor, other.getYcor)
	}

	public static Cell random(int N, double p) {
		Cell[] a = new Cell[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int r = (int)Math.random();
				if (r >= 0.5) a[i].set(j, new Alive(i, j));
				else a[i].set(j, new Dead(i, j));
			}
		}
		return a;
	}

}
