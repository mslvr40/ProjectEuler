//If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?


public class Problem17 {
	public static void main(String[] args) {
	
		//1,2,3,4,...19
		int[] ones = {0,3,3,5,4,4,3,5,5,4};
		int[] teens = {3,6,6,8,8,7,7,9,8,8};
		//20 30,40...90
		int[] tens = {6,6,6,5,5,7,6,6};
		int hundreds = 0;
		int sum = 0;
		//1-9
		
		for(int hundred :ones) {
			if(hundreds !=0) {
				hundreds+=hundred;
				sum+=hundreds;
				hundreds+=3;
			}
			
			for(int one : ones) {
				if(hundreds !=0 &&one ==0){
					continue;
				}
				sum +=one+hundreds;
			}
			//10-19
			for(int teen :teens) {
				sum+=teen+hundreds;
			}
			
			//20-100
			for(int ten:tens) {
				for(int one:ones) {
					sum+=(one+ten+hundreds);
				}
			}
			hundreds=7;
		}
		sum+=11;
		System.out.println(sum);
		
		
	}
}
