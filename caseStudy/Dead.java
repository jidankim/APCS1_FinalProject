import java.util.ArrayList;

public class Dead extends Cell {

	private int xCor;
	private int yCor;
	private String state;	
	private static final int[][] NEIGHBORS = {
	    {-1, -1}, {-1, 0}, {-1, +1},
   	    { 0, -1},          { 0, +1},
   	    {+1, -1}, {+1, 0}, {+1, +1}};

	public Dead(int x, int y) {
		xCor = x;
		yCor = y;
		state = "Dead";		
	}

	public void draw() {
		double[] xs = {x, x + 1.0, x + 1.0, x};
		double[] ys = {y, y + 1.0, y + 1.0, y};
		StdDraw.filledPolygon(xs, ys);
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
                  if (count == 3) return true;
                  return false;
          }
  
          public void changeState(ArrayList<ArrayList<Cell>> board) {
                  int x = this.getxCor();
                  int y = this.getyCor();
                  board.get(x).set(y, new Alive(x, y));
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
