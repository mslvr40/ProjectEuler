
public class Problem2 {
	//Add all the even fobbonacci numbers under 4 million
	public static void main(String[] args) {
		int sum = 0;
		for(int i = 1,j=2 ; j<4000000 ; j+=i,i=j-i) {
			if(j%2==0) {
				sum+=j;
			}
		}
		System.out.println(sum);
	}
	
}
