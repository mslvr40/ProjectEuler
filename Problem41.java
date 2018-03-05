import java.util.ArrayList;
//What is the largest n-digit pandigital prime that exists?

//7 seconds run time...my worst yet
public class Problem41 {
	static ArrayList<Integer> primes = new ArrayList<Integer>();

	public static void main(String[] args) {

		long startTime = System.nanoTime();
		sieve();
		for (int i = primes.size() - 1; i > 0; i--) {
			if (isPal(Integer.toString(primes.get(i)))) {
				System.out.println(primes.get(i));
				break;
			}
		}
		System.out.println((System.nanoTime() - startTime) / 1000000 + "ms");

	}

	static boolean isPal(String s) {
		boolean[] b = new boolean[s.length() + 1];
		for (char c : s.toCharArray()) {
			if (c == '0' || c > s.length() + 48) {
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

	static void sieve() {
		int n = 87654322;
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
