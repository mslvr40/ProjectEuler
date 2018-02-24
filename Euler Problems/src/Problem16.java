import java.math.BigInteger;

public class Problem16 {
	public static void main(String[] args) {
		BigInteger num =new BigInteger("2");
		num =num.pow(1000);
		String s = num.toString();
		int count = 0;
		for(int i = 0;i<s.length();i++) {
			count+=Character.getNumericValue(s.charAt(i));
		}
		System.out.println(count);
	}

}
