public class Input {

	public static void main(String[] args) {
		while (!StdIn.isEmpty()) {
			double price = StdIn.readDouble();
			StdOut.printf("%7.3f\n", price);
		}
	}	

}
