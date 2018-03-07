
//What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?

public class Problem46 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		boolean[] isPrime = sieve();
		boolean[] check = new boolean[10001];
		for (int i = 2; i < isPrime.length; i++) {
			if (!isPrime[i]) {
				continue;
			}
			for (int j = 1; j <= 100 && j * j * 2 + i <= 10000; j++) {
				check[j * j * 2 + i] = true;
			}
		}
		for (int i = 3; i < 10001; i += 2) {
			if (isPrime[i] || check[i]) {
				continue;
			}
			System.out.println(i);
			System.out.println((System.nanoTime() - startTime) / 1000000 + "ms");
			System.exit(0);

		}
	}

	static boolean[] sieve() {
		int n = 10001;
		boolean[] isPrime = new boolean[n];
		for (int i = 2; i < n; i++) {
			isPrime[i] = true;
		}
		for (int i = 2; i * i < n; i++) {
			if (isPrime[i]) {
				for (int j = i; i * j < n; j++) {
					isPrime[i * j] = false;
				}
			}
		}
		return isPrime;
	}
}
