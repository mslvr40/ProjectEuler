//Find the sum of all numbers which are equal to the sum of the factorial of their digits.

public class Problem34 {

	public static void main(String[] args) {

		int[] facts = new int[10];
		for (int i = 0, curr=1; i < 10; i++,curr*=i) {
			facts[i]=curr;
		}

		long startTime = System.nanoTime();
		double total = 0;
		for (int i = 3; i < 8 * facts[9]; i++) {
			int sum = 0;
			int n = i;
			while (n != 0) {
				sum += facts[(n % 10)];
				n /= 10;
			}
			if (sum == i) {
				total += i;
			}
		}
		System.out.println(total);
		System.out.println((System.nanoTime() - startTime) / 1000000 + "ms");
	}

}
