import java.util.ArrayList;

public class Invest {

	static ArrayList<Double> prices;	

	public static void main(String[] args) {
		prices = new ArrayList<Double>();
		
		while (!StdIn.isEmpty()) {
			prices.add(StdIn.readDouble());
		}

		Double cash = 10000.0;
		Double shares = 0.0;
		Double value = 10000.0;
		
		StdOut.printf("period   price     cash       shares    value\n");
		StdOut.printf("-----------------------------------------------\n");
		int N = prices.size();
		for (int i = 0; i < 3; i++)
			StdOut.printf("%4d%10.3f%11.2f%11.2f%11.2f\n", i+1, prices.get(i), cash, shares, value);
		
		// sell or buy according to Dilbert's rule
		for (int i = 3; i < N; i++) {
			String toDo = detect(i);
			if (toDo.equals("buy")) {
				shares = cash / prices.get(i);
				cash = 0.0;
			}
			if (toDo.equals("sell")) {
				cash = shares * prices.get(i);
				shares = 0.0;
			}
			if (cash == 0) value = shares * prices.get(i);
			if (shares == 0) value = cash;

			StdOut.printf("%4d%10.3f%11.2f%11.2f%11.2f\n", i+1, prices.get(i), cash, shares, value);		
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
