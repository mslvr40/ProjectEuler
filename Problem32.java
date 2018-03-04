import java.util.Arrays;

//Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.

public class Problem32 {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int total = 0;
		for (int i = 1; i < 100; i++) {
			for (int j = 100; j * i < 9999; j++) {
				String s = "";
				char[] chars = (s + i + s + j + (i * j)).toCharArray();
				if (chars.length != 9) {
					continue;
				}
				Arrays.sort(chars);
				String sorted = new String(chars);
				if (sorted.equals("123456789")) {
					System.out.println(i * j);
					total += (i * j);
				}

			}
		}
		System.out.println(total);
		System.out.println((System.nanoTime() - startTime) / 1000000 + "ms");

	}

}
