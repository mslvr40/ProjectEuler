//What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?

public class Problem24 {
	static int count = 0;
	public static void main ( String[] args )
	{
		long startTime = System.nanoTime();
		String items = "0123456789";
		outputChoices ( "", items);
		System.out.println((System.nanoTime() - startTime)/1000000 + "ms");

	}


	private static void outputChoices ( String fixedPart, String choosingPart )
	{
		if (choosingPart.length() == 1 )  {      // BASE CASE
			count++;
			if(count==1000000) {
				System.out.println ( fixedPart + choosingPart );
			}
		}

		else                                       // GENERAL CASE
		{   
			if(count==1000000) {
				return;
			}
			for(int i=0; i<choosingPart.length(); i++)
			{
				outputChoices (fixedPart + choosingPart.charAt(i), choosingPart.substring(0, i) + choosingPart.substring(i+1) );
			}
		}
		int x = 0;  
	}
}
