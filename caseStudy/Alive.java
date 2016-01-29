import java.util.ArrayList;

public class Alive extends Cell {

	private int xCor;
	private int yCor;
	private String state = "Alive";
	private static final int[][] NEIGHBORS = {
	    {-1, -1}, {-1, 0}, {-1, +1},
   	    { 0, -1},          { 0, +1},
   	    {+1, -1}, {+1, 0}, {+1, +1}};

	
	public Alive(int x, int y) {		
		xCor = x;
		yCor = y;
		state = "Alive";
	}

	public void draw(int x, int y) {	
		double[] xs = {(double)x, x + 1.0, x + 1.0, (double)x};
		double[] ys = {(double)y, y + 1.0, y + 1.0, (double)y};
		StdDraw.polygon(xs, ys);
	}

	public boolean checkChange(ArrayList<ArrayList<Cell>> board) {
		int x = this.getxCor();
		int y = this.getyCor();
		int count = 0;
		for (int[] offset : NEIGHBORS) {
			if (Life.getTile(x + offset[1], y + offset[1]).getState().equals("Alive")) {
				count++;
			}
		}
		if (count == 1 || count > 3) return true;
		return false;
	}

	public void changeState(ArrayList<ArrayList<Cell>> board) {
		int x = this.getxCor();
		int y = this.getyCor();
		board.get(x).set(y, new Dead(x, y));
	}

	public String getState() {
		return state;
	}

	public int getxCor() {
		return xCor;
	}

	public int getyCor() {
		return yCor;
	}

}
