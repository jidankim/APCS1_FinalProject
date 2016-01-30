public abstract class Cell {

	protected int xCor;
	protected int yCor;
	protected String state;

	public Cell(int x, int y) {
		xCor = x;
		yCor = y;
		state = "";
	}

	public abstract int getxCor();
	public abstract int getyCor();
	public abstract String toString();
}
