import java.util.ArrayList;

public abstract class Cell {

	private int xCor;
	private int yCor;
	private String state;
		
	public Cell() {
		xCor = 0;
		yCor = 0;
		state = "";
	}	

	public abstract void draw(int x, int y);
	public abstract boolean checkChange(ArrayList<ArrayList<Cell>> b);
	public abstract void changeState(ArrayList<ArrayList<Cell>> b);
	public abstract String getState();
	public abstract int getxCor();
	public abstract int getyCor();

}
