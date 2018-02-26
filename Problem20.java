import java.math.BigInteger;

public class Problem20 {
	public static void main(String[] args) {
		BigInteger x = BigInteger.ONE;
		for(int i = 2;i<=100;i++) {
			x=x.multiply(new BigInteger(Integer.toString(i)));
		}
		int count = 0;
		for(char c : x.toString().toCharArray()) {
			count+= Character.getNumericValue(c);
		}
		System.out.println(count);
	}

}
