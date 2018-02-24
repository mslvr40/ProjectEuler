import java.text.DecimalFormat;

//How many such routes are there through a 20×20 grid?
public class Problem15 {

	public static void main(String[] args) {
		int n = 21;
		double[][] table = new double [n][n];
		for(int i =0;i<n;i++) {
			table[i][0]=1;
			table[0][i]=1;
		}
		
		for(int i = 1;i<n;i++) {
			for(int j = 1;j<n;j++) {
				table[i][j] = table[i-1][j]+table[i][j-1];
			}
		}
		System.out.println(new DecimalFormat().format( table[n-1][n-1]));
		
	}
}
