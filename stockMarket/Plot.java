public class Plot {

	public static void main(String[] args) {
		while (!StdIn.isEmpty()) {
			int price = (int)(StdIn.readDouble());
			for (int i = 0; i < price; i++)
				System.out.print("*");
			System.out.println();
		} 
	}

}
