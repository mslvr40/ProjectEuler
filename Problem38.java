//What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer with (1,2, ... , n) where n > 1?

// bounds from 9234 to 9487 means for n=2 must be a 9 digit concatination 
public class Problem38 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		for (int i = 9487; i >= 9234; i--) {
			String s = Integer.toString(i);
			s += Integer.toString(i * 2);
			if (isPal(s)) {
				System.out.println(s);
				System.out.println((System.nanoTime() - startTime) / 1000000 + "ms");
				System.exit(0);

			}
		}
	}

	static boolean isPal(String s) {
		boolean[] b = new boolean[10];
		for (char c : s.toCharArray()) {
			if (c == '0') {
				return false;
			}
			if (!b[Character.getNumericValue(c)]) {
				b[Character.getNumericValue(c)] = true;
			} else {
				return false;
			}
		}
		return true;
	}

}
