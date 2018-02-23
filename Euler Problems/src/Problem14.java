//Which starting number, under one million, produces the longest Collatz chain?
public class Problem14 {
	static boolean checked[] = new boolean[1000000];
	public static void main(String[] args) {
		int chain=0;
		int highest = 0;
		for(int i = 0; i<1000000;i++) {
			checked[i] = false;
		}
		
		for(int i = 999999; i >0;i--) {
			if(!checked[i] && check(i)>chain) {
					chain = check(i);
					highest=i;
			}
		}
		System.out.println(highest);
	}	
	
	public static int check(double n) {
		int chain = 1;
		while(n!=1) {
			if(n%2==0) {
				n/=2;
			}
			else {
				n= 3*n+1;
			}
			chain++;
			if(n<1000000) {
				checked[(int)n]=true;
			}
		}
		return chain;
	}
	
	
}
