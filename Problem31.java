//How many different ways can £2 be made using any number of coins?
public class Problem31 {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int[] vals = { 200, 100, 50, 20, 10, 5, 2, 1 };
		int[][] table = new int[9][201];
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				if (j == 0) {
					table[i][j] = 1;
				} else {
					table[i][j] = 0;
				}
			}
		}

		for (int i = 1; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				if (j + vals[i - 1] <= 200) {
					table[i][j + vals[i - 1]] = table[i][j] + table[i - 1][j + vals[i - 1]];
				}

			}
		}
		System.out.println(table[table.length - 1][table[table.length - 1].length - 1]);
		System.out.println((System.nanoTime() - startTime) / 1000000 + "ms");

	}

}
