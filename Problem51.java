//Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits) with the same digit, is part of an eight prime value family.
//not the prettiest solution but its running under 100ms :)

import java.util.ArrayList;

public class Problem51 {
	static ArrayList<Integer> primes = new ArrayList<Integer>();

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		sieve(1000000);

		for (int n : primes) {
			String s = Integer.toString(n);
			for (int i = 0; i <= 9; i++) {
				int[] digits = new int[3];
				int count = 0;
				for (int j = 0; j < 5; j++) {
					if (s.charAt(j) - 48 == i) {
						if (!(count >= 3)) {
							digits[count] = j;
						}
						count++;

					}
				}
				if (count == 3) {
					if (shuffle(n, digits) == 8) {
						System.out.println(n);
						System.out.println((System.nanoTime() - startTime) / 1000000 + "ms");
						System.exit(0);
					}
					break;
				}
			}

		}

	}

	public static int shuffle(int n, int[] digits) {
		String s = Integer.toString(n);
		int count = 0;
		for (int i = s.charAt(digits[0]) - 48; i < 10; i++) {
			for (int j = 0; j < 3; j++) {
				s = s.substring(0, digits[j]) + i + s.substring(digits[j] + 1);
			}
			if (primes.contains(Integer.parseInt(s))) {
				count++;
			}
		}
		return count;
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
		for (int i = 100000; i < n; i++) {
			if (isPrime[i]) {
				primes.add(i);
			}
		}
	}

	public static boolean repeated(int n) {
		String s = Integer.toString(n);
		for (int i = 0; i <= 9; i++) {
			int count = 0;
			for (int j = 0; j < 5; j++) {
				if (s.charAt(j) - 48 == i) {
					count++;
				}
			}
			if (count == 3) {
				return true;
			}
		}
		return false;
	}
}
