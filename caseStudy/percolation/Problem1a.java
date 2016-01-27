public class Problem1a extends Problem1Matrix{

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		boolean[][] mat1 = new boolean[N][N];
		
		markRelPrime(mat1);
		printBooleanMat(mat1);
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

}
