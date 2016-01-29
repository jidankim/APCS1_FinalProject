public class Dead extends Cell {

	private int xCor;
	private int yCor;
	
	public Dead(int x, int y) {
		double[] xs = {x, x + 1.0, x + 1.0, x};
		double[] ys = {y, y + 1.0, y + 1.0, y};
		StdDraw.filledSquare(xs, ys);		
	}

//	public void draw() {

//	}
	
	publc Cell changeState() {
		return new Alive(xCor, yCor);
	}	

	public int getxCor() {
		return xCor;
	}

	public int geryCor() {
		return yCor;
	}

}
