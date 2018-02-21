import java.util.ArrayList;

public class Problem7 {
	static ArrayList primes = new ArrayList();
	public static void main(String[] args) {
		sieve();
		System.out.println(primes.get(10000));
	}
	public static void sieve(){
		int n = 200000;
		boolean[] isPrime = new boolean[n];
		for(int i=0;i<n;i++){
			isPrime[i] = true;
		}
		
		for(int i = 2;i<=Math.sqrt(n);i++){
			if( isPrime[i]){
				for(int j = i; i*j<n;j++){
					isPrime[j*i]=false;
				}
			}
		}
		for(int i =2;i<isPrime.length;i++){
			if(isPrime[i]){
				primes.add(i);
			}
		}
		
	}
}
