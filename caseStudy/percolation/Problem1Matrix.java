/******************************************************************************
 *  Compilation:  javac Problem1Matrix.java
 *  Execution:    N/A
 *
 *  Superclass for all parts of problem 1 that requires printing out two-
 *  dimensional boolean array, using * to represent true and a space to 
 *  represent false, including row and column numbers.
 *
 ******************************************************************************/


public class Problem1Matrix {

	// O(N^2)
	// pre: non-empty two-dimensional boolean array
	// post: * to represent true and space to represent false
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
