public class Problem1Matrix {

	public static void printBooleanMat(boolean[][] mat) {
                int N = mat.length;
		StdOut.printf("        ");
		for (int i = 0; i < N; i++) 
			StdOut.printf("%d", i);	
                StdOut.printf("\n");
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
