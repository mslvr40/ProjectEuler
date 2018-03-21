//slow brute force. ill find a better one
public class Problem56 {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		double prime = 0;
		double total = 1;
		boolean[] isPrime = sieve(1000000000);
		for (int s = 3; s * s < 1000000000; s += 2) {
			if (isPrime[s * s]) {
				prime++;
			}
			if (isPrime[(s * s) - (s - 1)]) {
				prime++;
			}
			if (isPrime[(s * s) - 2 * (s - 1)]) {
				prime++;
			}
			if (isPrime[(s * s) - 3 * (s - 1)]) {
				prime++;
			}
			total += 4;
			System.out.println(prime / total);
			if (prime / total <= .1) {
				System.out.println(s);
				System.out.println((System.nanoTime() - startTime) / 1000000 + "ms");
				System.exit(0);
			}
		}
	}

	static boolean[] sieve(int n) {

		boolean[] isPrime = new boolean[n + 1];
		for (int i = 2; i <= n; i++) {
			isPrime[i] = true;
		}

		for (int factor = 2; factor * factor <= n; factor++) {

			if (isPrime[factor]) {
				for (int j = factor; factor * j <= n; j++) {
					isPrime[factor * j] = false;
				}
			}
		}
		return isPrime;
	}
}
