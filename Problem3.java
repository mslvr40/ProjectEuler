import java.text.DecimalFormat;

public class Problem3 {
	public static void main(String[] args) {
		double n =600851475143.0;
		for(int i =2;;i++) {
			while(n%i==0) {
				System.out.println("n: " + new DecimalFormat().format(n) + "  i: "+i);
				n=n/i;
				if (n==1 ||n==i) {
					System.out.println(i);
					System.exit(0);
				}
			}
		}
	}

}
