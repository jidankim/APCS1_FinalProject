public class Alive extends Cell {

	public Alive(int x, int y) {
		super(x, y);
		state = "Alive";
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
