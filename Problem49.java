import java.util.ArrayList;
import java.util.Arrays;

public class Problem49 {
	static ArrayList<Integer> primes = new ArrayList<Integer>();

	public static void main(String[] args) {
		sieve();
		for (int i = 0; i < primes.size(); i++) {
			
			int p1 = primes.get(i);
			if(p1==1487) {
				continue;
			}
		
			for (int j = i + 1; j < primes.size(); j++) {
				int p2 = primes.get(j);
		
				if(isPerm(p1,p2)) {
					if(primes.contains(p2+p2-p1) && isPerm(p1, p2+p2-p1)) {
						System.out.println(p1+ "" + p2 + "" + (p2+p2-p1));
					}
				}
				
			}
		}
	}

	static boolean isPerm(int i, int j){
		
		char[] ip = Integer.toString(i).toCharArray();
		char[] jp =  Integer.toString(j).toCharArray();
		Arrays.sort(ip);
		Arrays.sort(jp);

		return Arrays.equals(ip, jp);
		
	}

	static void sieve() {
		int n = 10000;
		boolean[] isPrime = new boolean[n];
		for (int i = 2; i < n; i++) {
			isPrime[i] = true;
		}
		for (int i = 2; i * i < n; i++) {
			if (isPrime[i]) {
				for (int j = i; i * j < n; j++) {
					isPrime[i * j] = false;
				}
			}
		}
		for (int i = 1000; i < n; i++) {
			if (isPrime[i]) {
				primes.add(i);
			}
		}
	}
}
