import java.math.BigInteger;

//Find the last 1- digits of 1^1+2^2+3^3+....1000^1000
public class Problem48 {
	//Easy Brute force solution. I'm sure that theres a way you can get this working with modulo but this is easy and fast and I'm tired
	//might come back to it.
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		BigInteger n = BigInteger.ZERO;
		for (int i = 1; i <= 1000; i++) {

			n=n.add(new BigInteger(Integer.toString(i)).pow(i));

		}
		String s = n.toString();
		System.out.println(s.substring(s.length()-10));
		System.out.println((System.nanoTime() - startTime) / 1000000 + "ms");

	}
}
