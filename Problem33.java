//If the product of these four fractions is given in its lowest common terms, find the value of the denominator.

public class Problem33 {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int num = 1;
		int den = 1;
		for (int i = 99; i > 10; i--) {
			for (int j = i - 1; j > 10; j--) {
				if (j % 10 == i % 10 && i % 10 != 0) {
					if ((double) (j / 10) / (double) (i / 10) == (double) j / (double) i) {
						num *= j;
						den *= i;
					}
				}

				if (j % 10 == i / 10 && i / 10 != 0) {
					double one = (double) (j / 10) / (double) (i % 10);
					double two = (double) j / (double) i;
					if ((double) (j / 10) / (double) (i % 10) == (double) j / (double) i) {

						num *= j;
						den *= i;
					}
				}

				if (j / 10 == i % 10 && i % 10 != 0) {
					if ((double) (j % 10) / (double) (i / 10) == (double) j / (double) i) {
						num *= j;
						den *= i;
					}
				}

				if (j / 10 == i / 10 && i / 10 != 0) {
					if ((double) (j % 10) / (double) (i % 10) == (double) j / (double) i) {
						num *= j;
						den *= i;
					}
				}

			}
		}
		System.out.println(simplify(num, den));
		System.out.println((System.nanoTime() - startTime) / 1000000 + "ms");

	}

	public static String simplify(int a, int b) {
		int gcm = gcm(a, b);
		return (a / gcm) + "/" + (b / gcm);
	}

	public static int gcm(int a, int b) {

		if (b == 0) {
			return a;
		} else {
			return gcm(b, a % b);
		}
	}

}
