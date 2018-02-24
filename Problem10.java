import java.text.DecimalFormat;
//Find the sum of all the primes below two million.


import java.util.ArrayList;

public class Problem10 {
	
	public static ArrayList<Integer> primes=new ArrayList<Integer>();
	
	
	public static void main(String[] args) {
		double sum = 0;
		sieve();
		for(int x : primes) {
			sum+=x;
		}
		System.out.println(new DecimalFormat().format(sum));
	}
	
	public static void sieve(){
	
		int n = 2000000;
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

