//Find the smallest cube for which exactly five permutations of its digits are cube.

import java.util.Arrays;

public class Problem62 {
	public static void main(String[] args){
		long startTime=System.nanoTime();
		for(int i =406;;i++){
			String one = Long.toString((long)Math.pow(i,3));
			for(int j=i+1,count=1;;j++){
				if(count==5){
					System.out.println(one);
					System.out.println((System.nanoTime() - startTime) / 1000000 + "ms");
					System.exit(0);
				}
				String two = Long.toString((long)Math.pow(j,3));
				 if (one.length() != two.length()){
					 break;
				 }
				 if(isPerm(one,two)){
					 count++;
				 }
			}
		}
		
	}
	public static boolean isPerm(String str1, String str2) {

	
	    char[] a = str1.toCharArray();
	    char[] b = str2.toCharArray();

	    Arrays.sort(a);
	    Arrays.sort(b);

	    return Arrays.equals(a, b);
	}
}
