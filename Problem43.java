import java.text.DecimalFormat;

public class Problem43 {
	static double total = 0;

	public static void main(String[] args) {
		long startTime=System.nanoTime();
		permutation("", "0123456789");
		System.out.println(new DecimalFormat().format(total));
		System.out.println((System.nanoTime() - startTime) / 1000000 + "ms");
	}

	private static void permutation(String p, String s) {

		if (p.length() >= 4) {
			if (!check(p)) {
				return;
			}
		}

		if (s.length() == 0) {
			total+=Double.parseDouble(p);
		} else {
			for (int i = 0; i < s.length(); i++)
				permutation(p + s.charAt(i), s.substring(0, i) + s.substring(i + 1, s.length()));
		}
	}

	private static boolean check(String s) {
		if (s.length() == 4) {
			if (Integer.parseInt(s.substring(1, 4)) % 2 != 0) {
				return false;
			}
		} else if (s.length() == 5) {
			if (Integer.parseInt(s.substring(2, 5)) % 3 != 0) {
				return false;
			}
		} else if (s.length() == 6) {
			if (Integer.parseInt(s.substring(3, 6)) % 5 != 0) {
				return false;
			}
		} else if (s.length() == 7) {
			if (Integer.parseInt(s.substring(4, 7)) % 7 != 0) {
				return false;
			}
		} else if (s.length() == 8) {
			if (Integer.parseInt(s.substring(5, 8)) % 11 != 0) {
				return false;
			}
		} else if (s.length() == 9) {
			if (Integer.parseInt(s.substring(6, 9)) % 13 != 0) {
				return false;
			}
		} else if (s.length() == 10) {
			if (Integer.parseInt(s.substring(7, 10)) % 17 != 0) {
				return false;
			}
		}
		return true;

	}
}
