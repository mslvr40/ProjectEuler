
public class Problem1 {
	//sum all multiples of 3 or 5 under 1000 without using division or modulo
	public static void main(String[] args) {
		boolean [] ism = new boolean[1000];
		for(boolean b : ism) {
			b=false;
		}
		for(int i = 1;i*3<1000;i++) {
			ism[i*3] = true;
		}
		for(int i = 1;i*5<1000;i++) {
			ism[i*5] = true;
		}
		int sum = 0;
		for(int i=0;i<ism.length;i++) {
			if(ism[i]) {
				sum+=i;
			}
		}
		System.out.println(sum);
	}
}
