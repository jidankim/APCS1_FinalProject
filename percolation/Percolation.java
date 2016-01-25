public class Percolation {

	static int[][] grid; 
	static int N;

	// create N-by-N grid, with all sites blocked
	public Percolation (int n) {
		if (n <= 0) throw new IllegalArgumentException();
		N = n;
		grid = new int[N][N];
		for (int i = 0; i < N; i++) 
			for (int j = 0; j < N; j++) 
				grid[i][j] = 0; // 0 = block
	}

	public boolean inBound(int i, int j) {
		return i >= 0 && i < N && j >= 0 && j < N;
	}

	// open site (row i, column j) if it is not open already
	public void open(int i, int j) {
		if (!inBound(i,j)) throw new IndexOutOfBoundsException();
		grid[i][j] = 1; // 1 = open
	}

	// is site (row i, column j) open?
	public boolian isOpen(int i, int j) {
		if (!inBound(i,j)) throw new IndexOutOfBoundsException();
		grid[i][j] = 1; // 1 = open
		return grid[i][j] == 1;
	}

	// is site (row i, column j) full?
	public boolean isFull(int i, int j) {
		if (!inBound(i,j)) throw new IndexOutOfBoundsException();
		if (i == 0 && isOpen(i,j)) return true;
		
		return isOpen(i, j) && (isFull(i-1,j) || isFull(i+1,j)
					|| isFull(i,j-1) || isFull(i,j+1));
	}

	// does the system percolate?
	public boolean percolates() {
		for (int i = 0; i < N; i++)
			if (isFull[N-1][i])
				return true;
		return false;
	}
}
