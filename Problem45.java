//Find the next triangle number that is also pentagonal and hexagonal.
public class Problem45 {
	public static void main(String[] args) {
		Long startTime = System.nanoTime();
		for (long h = 144;; h++) {
			long n = h * (2 * h - 1);
			if (isPent(n)) {
				System.out.println(n);
				System.out.println((System.nanoTime() - startTime) / 1000000 + "ms");
				System.exit(0);

			}

		}
	}

	public static boolean isPent(long n) {
		return ((Math.sqrt(24 * n + 1) + 1) % 6 == 0);

	}

}
