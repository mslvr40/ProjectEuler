import java.util.ArrayList;

//How many circular primes are there below one million?
//runs in 5 seconds, going to need to come back to this and make it faster
public class Problem35 {
	static ArrayList<Integer> primes = new ArrayList<Integer>();

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		sieve();
		boolean test = perm("719");
		int count = 0;
		for (int n : primes) {
			if (perm(Integer.toString(n))) {
				count++;
			}

		}
		System.out.println(count);
		System.out.println((System.nanoTime() - startTime) / 1000000 + "ms");

	}

	static boolean perm(String n) {
		for (int i = 0; i < n.length() - 1; i++) {
			n = n.charAt(n.length() - 1) + n.substring(0, n.length() - 1);
			if (!primes.contains(Integer.parseInt(n))) {
				return false;
			}
		}
		return true;
	}

	static void sieve() {
		int n = 1000000;
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
		for (int i = 2; i < n; i++) {
			if (isPrime[i]) {
				primes.add(i);
			}
		}
	}
}
