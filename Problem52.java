import java.util.Arrays;

//Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
//simple brute force

public class Problem52 {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int x = 10;
		for(int i= x;;i++ ) {
			if(i>=x*10/6) {
				x*=10;
				i=x;
				continue;
			}
			if(check(i)) {
				System.out.println(i);
				System.out.println((System.nanoTime() - startTime) / 1000000 + "ms");
				System.exit(0);

			}
			
		}
	}

	static boolean check(int n) {
		return isPerm(n, n * 2) && isPerm(n, n * 3) && isPerm(n, n * 4) && isPerm(n, n * 5) && isPerm(n, n * 6);
	}

	static boolean isPerm(int n, int m) {
		char[] cn = Integer.toString(n).toCharArray();
		char[] cm = Integer.toString(m).toCharArray();
		Arrays.sort(cn);
		Arrays.sort(cm);
		return Arrays.equals(cm, cn);
	}

}
