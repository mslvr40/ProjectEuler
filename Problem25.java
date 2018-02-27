//What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
import java.math.BigInteger;

public class Problem25 {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		BigInteger a = BigInteger.ZERO;
		BigInteger b = BigInteger.ONE;
		int i = 0;
		while( a.toString().length()<1000) {
			BigInteger temp = new BigInteger(a.toString());
			a = a.add(b);
			b = temp;
			i++;
		}
		System.out.println(i);
		System.out.println((System.nanoTime() - startTime)/1000000 + "ms");

	}

}
