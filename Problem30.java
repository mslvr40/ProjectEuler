//Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
public class Problem30 {
	public static void main(String[] args) {
		int finalSum = 0;
		long startTime = System.nanoTime();
		for (int i = 2; i <= (6 * 9 * 9 * 9 * 9 * 9); i++) {
			int sum = 0, n = i;
			while (n != 0) {
				int x = n % 10;
				n = n / 10;
				sum += Math.pow(x, 5);
			}
			if (sum == i) {
				finalSum += sum;
			}
		}
		System.out.println(finalSum);
		System.out.println((System.nanoTime() - startTime) / 1000000 + "ms");

	}
}
