/******************************************************************************
 *  Compilation:  javac Problem1b.java
 *  Execution:    java Problem1b N
 *  Dependencies: Problem1Matrix.java StdOut.java
 *
 *  Takes N (where N is a power of 2 ) from the command line and 
 *  draws a Hadamard matrix of order N.
 *
 *  % java Problem1b 8
 *
 *     01234567
 *  0	********
 *  1	* * * * 
 *  2	**  **  
 *  3	*  **  *
 *  4	****    
 *  5	* *  * *
 *  6	**    **
 *  7	*  * ** 
 *
 ******************************************************************************/

public class Problem1b extends Problem1Matrix {

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		boolean[][] mat2 = new boolean[N][N];

		markHadamard(mat2);
		printBooleanMat(mat2);
			
	}
	
	// O(N^3)
	// pre: 2 dimensional boolean matrix initialized to false
	//      size of the matrix > 0
	// post: 2 dimensional boolean Hadamard matrix of order N
	//       where N is the size of the given matrix
	public static void markHadamard(boolean[][] mat) {
		int N = mat.length;
		mat[0][0] = true;
	        for (int n = 1; n < N; n += n) {
       			for (int i = 0; i < n; i++) {
       				for (int j = 0; j < n; j++) {
					mat[i+n][j] = mat[i][j];
					mat[i][j+n] = mat[i][j];
					mat[i+n][j+n] = !mat[i][j];
                		}
          		}
       	        }
	}
	
}
