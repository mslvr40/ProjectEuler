import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

//This code is pretty ugly but oh well
public class Problem53 {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		try {
			int count = 0;
			Scanner sc = new Scanner(new File("src/input/p53.txt"));
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				char[] v1 = { line.charAt(0), line.charAt(3), line.charAt(6), line.charAt(9), line.charAt(12) };
				char[] s1 = { line.charAt(1), line.charAt(4), line.charAt(7), line.charAt(10), line.charAt(13) };
				char[] v2 = { line.charAt(15), line.charAt(18), line.charAt(21), line.charAt(24), line.charAt(27) };
				char[] s2 = { line.charAt(16), line.charAt(19), line.charAt(22), line.charAt(25), line.charAt(28) };
				for (int i = 0; i < 5; i++) {
					if (v1[i] == 'T') {
						v1[i] = 'A';
					} else if (v1[i] == 'J') {
						v1[i] = 'B';
					} else if (v1[i] == 'Q') {
						v1[i] = 'C';
					} else if (v1[i] == 'K') {
						v1[i] = 'D';
					} else if (v1[i] == 'A') {
						v1[i] = 'E';
					}
					if (v2[i] == 'T') {
						v2[i] = 'A';
					} else if (v2[i] == 'J') {
						v2[i] = 'B';
					} else if (v2[i] == 'Q') {
						v2[i] = 'C';
					} else if (v2[i] == 'K') {
						v2[i] = 'D';
					} else if (v2[i] == 'A') {
						v2[i] = 'E';
					}
				}
				Arrays.sort(v1);
				Arrays.sort(v2);
				Arrays.sort(s1);
				Arrays.sort(s2);

				if (check(v1, v2, s1, s2) == 1) {
					count++;
				}

			}
			System.out.println(count);
			System.out.println((System.nanoTime() - startTime) / 1000000 + "ms");

		} catch (FileNotFoundException E) {

		}
	}

	static int check(char[] v1, char[] v2, char[] s1, char[] s2) {
		boolean one = isRoyalFlush(v1, s1);
		boolean two = isRoyalFlush(v2, s2);
		if (one && !two) {
			return 1;
		}
		if (two && !one) {
			return 2;
		}
		if (two && one) {
			if (s1[0] > s2[0]) {
				return 1;
			}
			return 2;
		}
		one = isStraightFlush(v1, s1);
		two = isStraightFlush(v2, s2);
		if (one && !two) {
			return 1;
		}
		if (two && !one) {
			return 2;
		}
		if (two && one) {
			if (v1[0] > v2[0]) {
				return 1;
			}
			return 2;
		}
		one = isFourKind(v1);
		two = isFourKind(v2);
		if (one && !two) {
			return 1;
		}
		if (two && !one) {
			return 2;
		}
		if (two && one) {
			if (v1[2] > v2[2]) {
				return 1;
			}
			return 2;
		}
		one = isFullHouse(v1);
		two = isFullHouse(v2);
		if (one && !two) {
			return 1;
		}
		if (two && !one) {
			return 2;
		}
		if (two && one) {
			if (v1[2] > v2[2]) {
				return 1;
			}
			return 2;
		}
		one = isFlush(v1);
		two = isFlush(v2);
		if (one && !two) {
			return 1;
		}
		if (two && !one) {
			return 2;
		}
		if (two && one) {
			for (int j = 4; j >= 0; j--) {
				if (v1[j] > v2[j]) {
					return 1;
				} else if (v1[j] < v2[j]) {
					return 2;
				}
			}

		}
		one = isStraight(v1);
		two = isStraight(v2);
		if (one && !two) {
			return 1;
		}
		if (two && !one) {
			return 2;
		}
		if (two && one) {
			if (v1[4] > v2[4]) {
				return 1;
			} else if (v1[4] < v2[4]) {
				return 2;
			} else {
				if (s1[4] > s2[4]) {
					return 1;
				}
				return 2;
			}
		}
		one = isThreeKind(v1);
		two = isThreeKind(v2);
		if (one && !two) {
			return 1;
		}
		if (two && !one) {
			return 2;
		}
		if (two && one) {
			if (v1[2] > v2[2]) {
				return 1;
			}

			return 2;
		}
		one = isTwoPair(v1);
		two = isTwoPair(v2);
		if (one && !two) {
			return 1;
		}
		if (two && !one) {
			return 2;
		}
		if (two && one) {
			int p1pair = 0;
			int p2pair = 0;
			for (int j = 4; j > 0; j--) {
				if (v1[j] == v1[j - 1]) {
					p1pair = v1[j];
					break;
				}
			}
			for (int j = 4; j > 0; j--) {
				if (v2[j] == v2[j - 1]) {
					p2pair = v2[j];
					break;
				}
			}
			if (p1pair > p2pair) {
				return 1;
			} else if (p2pair > p1pair) {
				return 2;
			}
			for (int j = 0; j < 4; j++) {
				if (v1[j] == v1[j + 1]) {
					p1pair = v1[j];
					break;
				}
			}
			for (int j = 0; j < 4; j++) {
				if (v2[j] == v2[j + 1]) {
					p2pair = v2[j];
					break;
				}
			}
			if (p1pair > p2pair) {
				return 1;
			}
			return 2;

		}
		one = isTwoPair(v1);
		two = isTwoPair(v2);
		if (one && !two) {
			return 1;
		}
		if (two && !one) {
			return 2;
		}
		if (two && one) {
			int p1pair = 0;
			int p2pair = 0;
			for (int j = 0; j < 4; j++) {
				if (v1[j] == v1[j + 1]) {
					p1pair = v1[j];
					break;
				}
			}
			for (int j = 0; j < 4; j++) {
				if (v2[j] == v2[j + 1]) {
					p2pair = v2[j];
					break;
				}
			}
			if (p1pair > p2pair) {
				return 1;
			}
			return 2;
		}
		for (int j = 4; j >= 0; j--) {
			if (v1[j] > v2[j]) {
				return 1;
			} else if (v1[j] < v2[j]) {
				return 2;
			}
		}
		return 1;

	}

	static boolean isRoyalFlush(char[] v, char[] s) {
		char[] test = { 'A', 'B', 'C', 'D', 'E' };
		return Arrays.equals(v, test) && isFlush(s);
	}

	static boolean isStraightFlush(char[] v, char[] s) {
		return isStraight(v) && isFlush(s);
	}

	static boolean isFourKind(char[] l) {
		return l[0] == l[3] || l[1] == l[4];
	}

	static boolean isFullHouse(char[] l) {
		return (l[0] == l[2] && l[3] == l[4]) || (l[0] == l[1] && l[2] == l[4]);
	}

	static boolean isFlush(char[] l) {
		return l[0] == l[4];
	}

	static boolean isStraight(char[] l) {
		for (int i = 0; i < l.length - 1; i++) {
			if (l[i] == '9') {
				if (l[i + 1] != 'A') {
					return false;
				}
			} else if (l[i + 1] != l[i] + 1) {
				return false;
			}
		}
		return true;

	}

	static boolean isThreeKind(char[] l) {
		for (int i = 0; i < l.length - 2; i++) {
			if (l[i] == l[i + 2]) {
				return true;
			}
		}
		return false;
	}

	static boolean isTwoPair(char[] l) {
		boolean one = false;
		for (int i = 0; i < l.length - 1; i++) {
			if (one) {
				if (l[i] == l[i + 1]) {
					return true;
				}
			}
			if (l[i] == l[i + 1]) {
				one = true;
			}
		}
		return false;
	}

	static boolean isPair(char[] l) {
		for (int i = 0; i < l.length - 1; i++) {
			if (l[i] == l[i + 1]) {
				return true;
			}
		}
		return false;
	}

}
