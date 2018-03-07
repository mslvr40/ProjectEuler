//Find the pair of pentagonal numbers, Pi and Pj, for which their sum and difference are pentagonal and D = |Pi-Pj| is minimised; what is the value of D?
public class Problem44 {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		for (int i = 1;; i++) {
			long one = i * (3 * i - 1) / 2;
			for (int j = i - 1; j > 0; j--) {
				long two = j * (3 * j - 1) / 2;
				if (isPent(one - two) && isPent(one + two)) {
					System.out.println(one - two);
					System.out.println((System.nanoTime() - startTime) / 1000000 + "ms");
					System.exit(0);
				}
			}
		}

	}

	// algebra to isolate the n
	public static boolean isPent(long n) {
		return (Math.sqrt(24 * n + 1) + 1) % 6 == 0;
	}
}
