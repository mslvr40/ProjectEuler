import java.text.DecimalFormat;

//What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?


public class Problem28 {
	
	public static void main(String[] args){
		long startTime = System.nanoTime();

		double sum = 1;
		for(int i = 0,s=3;i<500;i++,s+=2) {
			
//			sum+=s*s; 			//top-right
//			sum+=(s*s)-(s-1);	//top-left
//			sum+=(s*s)-2*(s-1);	//bottom-left
//			sum+=(s*s)-3*(s-1);	//bottom-right
		
			sum+=4*(s*s) - 6*(s-1); 	//combined them
		}
		System.out.println(new DecimalFormat().format(sum));
		System.out.println((System.nanoTime() - startTime)/1000000 + "ms");

	}
	

}
