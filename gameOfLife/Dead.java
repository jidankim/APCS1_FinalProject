public class Dead extends Cell {

	public Dead(int x, int y) {
		super(x, y);
		state = "Dead";
	}

	public int getxCor() {
		return xCor;
	}

	public int getyCor() {
		return yCor;
	}

	public String toString() {
		return state;
	}
}
