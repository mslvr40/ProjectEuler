import java.math.BigInteger;

//Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
public class Problem6 {
	
	public static void main(String[] args) {
		BigInteger sumSquare = BigInteger.ZERO;
		BigInteger squareSum = BigInteger.ZERO;
		for(int i = 1; i<=100;i++) {
			sumSquare = sumSquare.add(new BigInteger(Integer.toString(i)));
		}
		sumSquare =sumSquare.pow(2);
		for(int i = 1; i<=100;i++) {
			squareSum= squareSum.add(new BigInteger(Integer.toString(i*i)));
		}
		
		System.out.println(sumSquare.subtract(squareSum));
	}
	
}
