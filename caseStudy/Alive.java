public class Alive extends Cell {

	private int xCor;
	private int yCor;
	
	public Alive(int x, int y) {
		double[] xs = {x, x + 1.0, x + 1.0, x};
		double[] ys = {y, y + 1.0, y + 1.0, y};
		StdDraw.square(xs, ys);		
	}

//	public void draw(double x, double y, double r) {
//		StdDraw.square(x, y, 0.5);
//	}

	public Cell changeState() {
		return new Dead(xCor, yCor);
	}

	public int getxCor() {
		return xCor;
	}

	public int getyCor() {
		return yCor;
	}

}
