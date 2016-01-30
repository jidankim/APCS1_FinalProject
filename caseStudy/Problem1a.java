/******************************************************************************
 *  Compilation:  javac Problem1a.java
 *  Execution:    java Problem1a N
 *  Dependencies: Problem1Matrix.java StdOut.java
 *   
 *  Takes N from the command line and draws an  N- by-N matrix with the entry
 *  in row i and column j set to true if i and j are relatively prime.  
 *
 *  % java Problem1a 10
 *
 *      0123456789
 *  0	 *        
 *  1	**********
 *  2	 * * * * *
 *  3	 ** ** ** 
 *  4	 * * * * *
 *  5	 **** ****
 *  6	 *   * *  
 *  7	 ****** **
 *  8	 * * * * *
 *  9	 ** ** ** 
 *
 ******************************************************************************/

public class Problem1a extends Problem1Matrix{

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		boolean[][] mat1 = new boolean[N][N];
		
		markRelPrime(mat1);
		printBooleanMat(mat1);
	}

	// O(N^2)
	// pre: 2 dimensional boolean matrix initialized to false
	//      size of the matrix > 0
	// post: 2 dimensional N-by-N boolean matrix with entry in row i 
	//       and column j set to true if i and j are relatively prime
	//       where N is the size of the given matrix
	public static void markRelPrime(boolean[][] mat) {
                int N = mat.length;
                for (int i = 0; i < N; i++)
                        for (int j = 0; j < N; j++)
                                if (gcd(i, j) == 1)
                                        mat[i][j] = true;


        }

	// O(N)
	// pre: 2 integers >= 0
	// post: the greatest common divisor of the smaller one 
	//       and greater one mod smaller one (Euclid's Algorithm)
        public static int gcd(int n1, int n2) {
                if (n2 == 0) return n1;
                return gcd(n2, n1%n2);
        }

}
