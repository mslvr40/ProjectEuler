//For which value of p <= 1000, is the number of solutions maximised?

//rearanged equation with a little algebra
public class Problem39 {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int high = 0;
		int highP=0;;
		for (double p = 1000; p > 0; p--) {
			int count = 0;
			for (double i = 2; i < p / 3; i++) {
				if (((p * p - 2 * p * i) / (2 * p - 2 * i)) % 1 == 0) {
					count++;
				}
			}
			if (count > high) {
				high = count;
				highP = (int) p;
			}
		}
		System.out.println(highP + "   " + high);
		System.out.println((System.nanoTime() - startTime) / 1000000 + "ms");

	}
}
