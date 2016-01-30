/******************************************************************************
 *  Compilation:  javac Invest.java
 *  Execution:    java Invest < stocks.txt
 *  Dependencies: StdOut.java StdIn.java
 *
 *  Creates a table that determines how much money you would have won or lost
 *  using Dilbert's rule given $10,000.00 cash and prices given in stocks.txt
 *
 *  % java Invest < stock15.txt
 *
 *  period   price     cash       shares    value
 *  -----------------------------------------------
 *  1    26.375   10000.00       0.00   10000.00
 *  2    25.500   10000.00       0.00   10000.00
 *  3    25.125   10000.00       0.00   10000.00
 *  4    25.000   10000.00       0.00   10000.00
 *  5    25.250       0.00     396.04   10000.00
 *  6    27.125       0.00     396.04   10742.57
 *  7    28.250       0.00     396.04   11188.12
 *  8    26.000   10297.03       0.00   10297.03
 *  9    25.500   10297.03       0.00   10297.03
 *  10    25.000   10297.03       0.00   10297.03
 *  11    25.125       0.00     409.83   10297.03
 *  12    25.250       0.00     409.83   10348.26
 *  13    26.375       0.00     409.83   10809.32
 *  14    25.500   10450.72       0.00   10450.72
 *  15    25.500   10450.72       0.00   10450.72
 *
 ******************************************************************************/

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
			if (toDo.equals("buy") && cash != 0.0) {
				shares = cash / prices.get(i);
				cash = 0.0;
			}
			if (toDo.equals("sell") && shares != 0.0) {
				cash = shares * prices.get(i);
				shares = 0.0;
			}
			if (cash == 0) value = shares * prices.get(i);
			if (shares == 0) value = cash;

			StdOut.printf("%4d%10.3f%11.2f%11.2f%11.2f\n", i+1, prices.get(i), cash, shares, value);		
		}
	}

	// O(1)
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
