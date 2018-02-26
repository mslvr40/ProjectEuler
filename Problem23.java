
//Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.

import java.util.ArrayList;

public class Problem23 {
	public static void main(String[] args) {
		int total = 0;
		ArrayList<Integer> list = getList();
		boolean[] isSum = new boolean[28125];
		for (int i = 0; i < isSum.length; i++) {
			isSum[i] = false;
		}

		for (int i = 0; i < list.size(); i++) {
			for (int j = i; list.get(j) + list.get(i) < isSum.length; j++) {
				isSum[list.get(i) + list.get(j)] = true;
			}
		}
		for (int i = 0; i < isSum.length; i++) {
			if (!isSum[i]) {
				total += i;
			}
		}
		System.out.println(total);
	}

	public static ArrayList<Integer> getList() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < 28124; i++) {
			int count = 1;
			for (int j = 2; j * j <= i; j++) {
				if (i % j == 0) {
					if (j * j == i) {
						count += j;
					} else {
						count += j + (i / j);
					}
				}
			}
			if (count > i) {
				list.add(i);
			}
		}
		return list;
	}

}
