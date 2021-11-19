package array;

import java.util.ArrayList;
import java.util.List;

//https://algo.monster/problems/day_of_week
public class DaysOkWeekKth {

	private static final String MONDAY = "Monday";
	private static final String TUESDAY = "Tuesday";
	private static final String WEDNESDAY = "Wednesday";
	private static final String THURSDAY = "Thursday";
	private static final String FRIDAY = "Friday";
	private static final String SATURDAY = "Saturday";
	private static final String SUNDAY = "Sunday";

	private static final int NO_OF_DAYS_OF_WEEK = 7;

	public static String dayOfWeek(String day, int k) {
		List<String> daysOfWeek = new ArrayList<>();
		daysOfWeek.add(MONDAY);
		daysOfWeek.add(TUESDAY);
		daysOfWeek.add(WEDNESDAY);
		daysOfWeek.add(THURSDAY);
		daysOfWeek.add(FRIDAY);
		daysOfWeek.add(SATURDAY);
		daysOfWeek.add(SUNDAY);

		k %= NO_OF_DAYS_OF_WEEK;
		int indexOfInputDay = daysOfWeek.indexOf(day);
		int kthDay = indexOfInputDay + k;
		return daysOfWeek.get(kthDay);
	}

}
