//Evaluate the sum of all the amicable numbers under 10000.

public class Problem21 {
	public static void main(String[] args) {
		int total=0;
		for(int i = 9999; i>0;i--) {
			int sum = divSum(i);
			if(sum <i) {
				int sum2 = divSum(sum);
				if(i==sum2) {
					System.out.println(i);

					total+=sum+sum2;
				}
			}
		}
		System.out.println(total);
	}
		
	public static int divSum(int n) {
		int count = 1;
		for(int i = 2; i*i<n; i++) {
			if(n%i==0) {
				count+=i+(n/i);
				
			}
		}
		return count;
	}
}
