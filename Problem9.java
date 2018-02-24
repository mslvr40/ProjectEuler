//There exists exactly one Pythagorean triplet for which a + b + c = 1000.
//Find the product abc.

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Problem9 {
	public static void main(String[] args) {
		ArrayList<Double> squares = new ArrayList();
		for(int i = 2;i<900;i++) {
			squares.add((double)i*i);
		}
		System.out.println(squares.get(198));
		System.out.println(squares.get(373));

		for(int i = 0; i<squares.size()-2;i++) {
			for(int j = i+1;Math.sqrt(squares.get(i))+Math.sqrt(squares.get(j))+ Math.sqrt(squares.get(i)+squares.get(j))<=1000;j++) {
				if(!squares.contains(squares.get(i)+squares.get(j))){
					continue;
				}
				if(Math.sqrt(squares.get(i))+Math.sqrt(squares.get(j))+ Math.sqrt(squares.get(i)+squares.get(j))==1000) {
					System.out.println(new DecimalFormat().format(Math.sqrt(squares.get(i))*Math.sqrt(squares.get(j))* Math.sqrt(squares.get(i)+squares.get(j))));
				}
				
			}
		}
	}

}
