/******************************************************************************
 *  Compilation:  javac Problem1c.java
 *  Execution:    java Problem1c N
 *  Dependencies: Problem1Matrix.java StdOut.java
 *
 *  Takes N from the command line and draws an N- by-N matrix such with the
 *  entry in row N and column j set to true if the coefficient of x^k in 
 *  (1+x)^N (binomial coefficiant) is odd. 
 *
 *  % java Problem1c 10
 *
 *        0123456789
 *  0	          
 *  1	 *        
 *  2	 *        
 *  3	 **       
 *  4	 * *      
 *  5	 ****     
 *  6	 *   *    
 *  7	 **  **   
 *  8	 * * * *  
 *  9	 ******** 
 *
 ******************************************************************************/

public class Problem1c extends Problem1Matrix{

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		boolean[][] mat3 = new boolean[N][N];

		markOddCoeff(mat3);
		printBooleanMat(mat3);				
	}

	// O(N^2)
	// pre: 2 dimensional boolean matrix initialized to false
	//      size of the matrix > 0
	// post: 2 dimensional N-by-N boolean matrix with entry in 
	//       row N and column j set to true if the coefficient 
	//       of x^k in (1+x)^N (binomial coefficiant) is odd
	public static void markOddCoeff(boolean[][] mat) {
		int N = mat.length;
		int[][] bin = new int[N][N];
		for (int k = 0; k < N; k++) bin[k][0] = 0; 
		bin[1][1] = 1;
		for (int i = 2; i < N; i++) {
			for (int j = 1; j < i; j++) { 
				bin[i][j] = bin[i-1][j] + bin[i-1][j-1];
			}
		}
		for (int k = 0; k < N; k++) 
			for (int l = 0; l < N; l++)
				if (bin[k][l]%2 != 0) mat[k][l] = true;	
	}

}
