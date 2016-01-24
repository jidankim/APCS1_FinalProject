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

	public static void sierpinski(int n, double x, double y, double side) {	
		if (n == 0) return;
		
		double t = side * Math.sqrt(3.0)/2;
		
		triangle(x, y, side);
		sierpinski(n-1, x, y + t, side/2);
		sierpinski(n-1, x + side/2, y, side/2);
		sierpinski(n-1, x - side/2, y, side/2);
	}

	public static void triangle(double startX,double startY,double side) {
		double t = side * Math.sqrt(3.0)/2;
		double[] xd = {startX, startX - side/2, startX + side/2};
		double[] yd = {startY, startY + t, startY + t};
		StdDraw.filledPolygon(xd, yd); // draw a triangle 
	}	

}
