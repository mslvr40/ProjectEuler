import java.awt.List;
import java.util.ArrayList;

//Find the first four consecutive integers to have four distinct prime factors each. What is the first of these numbers?

public class Problem47 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		for (int i = 646;; i++) {

			if (getFactors(i).size() >= 4) {
				i++;
				if (getFactors(i).size() >= 4) {
					i++;
					if (getFactors(i).size() >= 4) {
						i++;
						if (getFactors(i).size() >= 4) {
							System.out.println(i - 3);
							System.out.println((System.nanoTime() - startTime) / 1000000 + "ms");
							System.exit(0);

						}
					}
				}
			}

		}

	}

	public static ArrayList<Integer> getFactors(int n) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 2; i <= n; i++) {
			while (n % i == 0) {
				if (!list.contains(i)) {
					list.add(i);
				}
				n /= i;
			}
		}
		return list;
	}

}
