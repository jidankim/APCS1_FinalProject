public class Sierpinski {

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
	
		// draw boundary
		double t = Math.sqrt(3.0) / 2;
		StdDraw.line(0.0, 0.0, 1.0, 0.0);
		StdDraw.line(1.0, 0.0, 0.5, t);
		StdDraw.line(0.5, t, 0.0, 0.0);
	
		sierpinski(N);
	}

	public static void sierpinski(int n) {	
		double side = Math.pow(2, -n);
		double t = side * Math.sqrt(3.0)/2;
		if (n == 1) triangle(side/2, t, side, t);
		else {
			sierpinski(n-1);`
		}
	}

	public static void triangle(double startX,double startY,double side,double t) {
		double[] xd = {startX, startX + side, startX + side/2};
		double[] yd = {startY, startY, startY - t};
		StdDraw.filledPolygon(xd, yd);
	}	

}
