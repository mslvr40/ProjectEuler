//A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
//Find the largest palindrome made from the product of two 3-digit numbers.
public class Problem4 {

	public static void main(String[] args) {
		
		int max = 0;
		for(int i = 100; i <=999;i++) {
			for(int j = i; j< 999;j++) {
				if(i*j>max && isPal(i*j)) {
					max = i*j;
				}
			}
		}
		System.out.println(max);
		
	}
	
	public static boolean isPal(int n) {
		String s = Integer.toString(n);
		for(int i = 0,j =s.length()-1; i<j;i++,j--) {
			if(s.charAt(i)!=s.charAt(j)) {
				return false;
			}
		}
		return true;
	}
}

