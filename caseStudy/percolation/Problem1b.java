public class Problem1b extends Problem1Matrix {

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		boolean[][] mat2 = new int[N][N];

		markHadamard(mat2);
		printBooleanMat(mat2);
			
	}

	public static void markHadamard(boolean[][] mat) {
		int N = mat.length;
		mat[0][0] = true;
		for (int n = 0; n < N; n*=2) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					mat[i+n][j] = mat[i][j];
					mat[i][j+n] = mat[i][j];
					mat[i+n][j+n] = mat[i][j];
				}
			}
		}
	}
	
}
