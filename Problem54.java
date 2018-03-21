import java.math.BigInteger;
//How many Lychrel numbers are there below ten-thousand?
public class Problem54 {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int count = 0;
		for (int i = 10; i < 10000; i++) {
			BigInteger t = new BigInteger(Integer.toString(i));
			for (long j = 0; j < 50; j++) {
				t = t.add(reverse(t));
				if (t.equals(reverse(t))) {
					break;
				}
				if (j == 49) {
					count++;
				}
			}

		}
		System.out.println(count);
		System.out.println((System.nanoTime() - startTime) / 1000000 + "ms");

	}

	static BigInteger reverse(BigInteger n) {
		return new BigInteger(new StringBuilder().append(n).reverse().toString());
	}

}
