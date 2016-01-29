import java.util.ArrayList;

public class Life {

	private static ArrayList<ArrayList<Integer>> board;
	private static int size;

	public static void main(String[] args) {
		size = Integer.parseInt(args[0]);
		board = new ArrayList<ArrayList<Integer>>(size);
		for (int i = 0; i < size; i++) {
			board.add(new ArrayList<Integer>());
			for (int j = 0; j < size; j++) {
				board.get(i).add(0);
			}
		}
		System.out.println(board);
		randomize();	
		System.out.println(board);
	}

	public static void randomize() {
		int i = 0, j = 0;
		System.out.println("hi");
		for (ArrayList<Integer> row : board) {
			System.out.println("am i here");
			for (Integer number : row) {
				System.out.print("current " + number);
				System.out.println("what about here");
				double r = Math.random();
				System.out.println(r);
				if (r >= 0.5) {
					board.get(i).set(j, 1);
				}
				System.out.print(j);
				j++;
			}
			i++;
		}
	}

}
