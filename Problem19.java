import java.util.Calendar;

//How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?

//Java library makes this easy

public class Problem19 {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		Calendar cal = Calendar.getInstance();
		int sundays = 0;
		for (int year = 1901; year <= 2000; year++) {
			for (int month = 0; month < 12; month++) {
				cal.set(year,month,0);
				if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY) {
					sundays++;
				}
			
			}
		}
		System.out.println(sundays);
		System.out.println((System.nanoTime() - startTime) / 1000000 + "ms");

	}
}
