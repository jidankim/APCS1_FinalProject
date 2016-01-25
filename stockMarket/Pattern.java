import java.util.ArrayList;

public class Pattern {
	
	static ArrayList<Double> prices;

	public static void main(String[] args) {
		prices = new ArrayList<Double>();
		
		while (!StdIn.isEmpty()) {
			prices.add(StdIn.readDouble());	
		}
		
		int N = prices.size();
		for (int i = 0; i < 3; i++) {
			StdOut.printf("%3d\t%-7.3f\n", i+1, prices.get(i));
		}
		for (int i = 3; i < N; i++) {
			StdOut.printf("%3d\t%-7.3f\t%s\n", i+1, prices.get(i), detect(i));
		}
	}

	// pre: n >= 4
	// post: String whether it should buy or sell or neither (empty)
	public static String detect(int n) {
		String ans = "";
		Double now = prices.get(n);
		Double prev = prices.get(n-1);
		Double prev2 = prices.get(n-2);
		Double prev3 = prices.get(n-3);
		if (now < prev && prev > prev2 && prev2 > prev3)
			ans = "sell";
		if (now > prev && prev < prev2 && prev2 < prev3)
			ans = "buy";
		return ans;
	}

}
