import java.util.ArrayList;

public class Problem50 {

	static ArrayList<Integer> primes = new ArrayList<Integer>();

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		sieve(1000000);
		int best = 0;
		int count = 0;
		for (int i = 0; i < primes.size(); i++) {
			int sum = 0;
			for (int j = i; j < primes.size(); j++) {
				sum += primes.get(j);
				if (sum > 1000000)
					break;
				else if (j - i >= count && sum > best && primes.contains(sum)) {
					best = sum;
					count = j - i;
				}
			}
		}
		System.out.println(best);
		System.out.println((System.nanoTime() - startTime) / 1000000 + "ms");

	}

	public static void sieve(int n) {
		boolean[] isPrime = new boolean[n];
		for (int i = 2; i < n; i++) {
			isPrime[i] = true;
		}
		for (int i = 2; i * i <= n; i++) {
			if (isPrime[i]) {
				for (int j = 2; j * i < n; j++) {
					isPrime[i * j] = false;
				}
			}
		}
		for (int i = 2; i < n; i++) {
			if (isPrime[i]) {
				primes.add(i);
			}
		}
	}
}
