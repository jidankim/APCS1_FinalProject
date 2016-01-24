/******************************************************************************
 *  Compilation:  javac Sierpinski.java
 *  Execution:    java Sierpinski N
 *  Dependencies: StdDraw.java
 *
 *  Plot an order N Sierpinski Triangle.
 *
 *  % java Sierpinski 5
 *
 ******************************************************************************/

public class Sierpinski {

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
	
		// draw boundary
		double t = Math.sqrt(3.0) / 2;
		StdDraw.line(0.0, 0.0, 1.0, 0.0);
		StdDraw.line(1.0, 0.0, 0.5, t);
		StdDraw.line(0.5, t, 0.0, 0.0);
	
		double x = 0.5, y = 0.0; // starting vertex
		double side = 0.5;
		sierpinski(N, x, y, side);
	}

	// O(n)
	// pre: n >= 0, 0 <= x <= 1, 0 <= y <= 1, side <= 0.5
	// post: draws sierpinski triangles of order n	
	public static void sierpinski(int n, double x, double y, double side) {	
		if (n == 0) return;
		triangle(x, y, side);

		double t = side * Math.sqrt(3.0)/2;
		
		// recursively draw 3 half-size Sierpinski of order n-1	
		sierpinski(n-1, x, y + t, side/2); // top 
		sierpinski(n-1, x + side/2, y, side/2); // left bottom
		sierpinski(n-1, x - side/2, y, side/2); // right bottom
	}

	// O(1)
	// pre: 0 <= startX <= 1, 0 <= startY <= 1, side <= 0.5
	// post: draws a triangle with a vertex at (startX, startY) and given side
	public static void triangle(double startX,double startY,double side) {
		double t = side * Math.sqrt(3.0)/2;

		double[] xd = {startX, startX - side/2, startX + side/2};
		double[] yd = {startY, startY + t, startY + t};
		StdDraw.filledPolygon(xd, yd); // draw a triangle 
	}	

}
