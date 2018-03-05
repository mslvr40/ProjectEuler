
//Find the sum of the only eleven primes that are both truncatable from left to right and right to left.

import java.util.ArrayList;

public class Problem37 {

	static ArrayList<Integer> primes = new ArrayList<Integer>();

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int sum = 0;
		int count = 0;
		sieve();
		for (int i = 4; i < primes.size(); i++) {
			if (isTrunc(Integer.toString(primes.get(i)))) {
				System.out.println(primes.get(i));
				sum += primes.get(i);
				count++;
				if (count == 11) {
					break;
				}
			}
		}
		System.out.println(sum);
		System.out.println((System.nanoTime() - startTime) / 1000000 + "ms");
	}

	static boolean isTrunc(String n) {
		String left = n;
		String right = n;
		for (int i = 0; i < n.length() - 1; i++) {
			left = left.substring(1, left.length());
			if (!primes.contains(Integer.parseInt(left))) {
				return false;
			}
			right = right.substring(0, right.length() - 1);
			if (!primes.contains(Integer.parseInt(right))) {
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
