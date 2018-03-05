import java.text.DecimalFormat;

//Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.

public class Problem36 {
	public static void main(String[] args) {

		long startTime = System.nanoTime();
		double sum = 0;
		for (int i = 1; i < 1000000; i++) {

			if (isPal(Integer.toString(i)) && isPal(Integer.toBinaryString(i))) {
				sum += i;
			}
		}
		System.out.println(new DecimalFormat().format(sum));
		System.out.println((System.nanoTime() - startTime) / 1000000 + "ms");

	}

	static boolean isPal(String n) {
		boolean ret = true;
		for (int i = 0, j = n.length() - 1; j > i; i++, j--) {
			if (n.charAt(i) != n.charAt(j)) {
				return false;
			}
		}
		return true;
	}

}
