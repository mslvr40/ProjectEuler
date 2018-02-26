//working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.
//What is the total of all the name scores in the file?


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.Arrays;

public class Problem22 {
	public static void main(String[] args) {
		long startTime = System.nanoTime();

		String[] names;
		try {
			String s = new String(Files.readAllBytes(Paths.get("src/names.txt")));
			s = s.substring(1, s.length() - 1);
			names = s.split("\",\"");
			Arrays.sort(names);
			double total = 0;
			for (int i = 0; i < names.length; i++) {
				int count = 0;
				for (int j = 0; j < names[i].length(); j++) {
					count += names[i].charAt(j) - 64;
				}
				total += count * (i + 1);
			}
			System.out.println(new DecimalFormat().format(total));
		} 
		catch (IOException e) {
			System.out.println(e);
		}
		long endTime = System.nanoTime();
		System.out.println((endTime - startTime)/1000000 + "ms");

	}
}
