public class Problem1 {

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		boolean[][] mat1 = new boolean[N][N];
		boolean[][] mat2 = new int[N][N];
		mat3 = new int[N][N];

		markRelPrime(mat1);
		mat2 = markHadamard(N);
			
	}

	public static boolean[][] markHadamard(int n) {
		if (n == 1) return {true};
		else {
			return 
		}
			
	}
	
	public static void markRelPrime(boolean[][] mat) {
		int N = mat.length;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				if (gcd(i, j) == 1)
					mat[i][j] = true;
			
		
	}

	public static int gcd(int n1, int n2) {
		if (n2 == 0) return n1;
		return gcd(n2, n1%n2);
	}

	public static void printBooleanMat(boolean[][] mat) {
		int N = mat.length;
		for (int i = 0; i < N; i++) {
			StdOut.printf("%3d\t", i);
			for (int j = 0; j < N; j++) {
				String ret = " ";
				if (mat[i][j]) ret = "*";
				StdOut.printf(ret);
			}
			StdOut.printf("\n");
		}	
	}

}
