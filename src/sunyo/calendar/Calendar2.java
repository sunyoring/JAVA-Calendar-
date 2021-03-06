package sunyo.calendar;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;

public class Calendar2 {

	private static final int[] maxDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAPmaxDays = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	//private HashMap<Date, PlanItem> planMap;

	private HashMap<Date, PlanItem> planMap;
	public Calendar2() {
		planMap = new HashMap<Date, PlanItem>();
	
	}

	/**
	 * 
	 * @param date ex : "2021-03-04"
	 * @param plan
	 * @throws ParseException
	 */
	public void registerPlan(String strDate, String plan) throws ParseException {

		PlanItem p = new PlanItem(strDate, plan) ;
		planMap.put(p.planDate, p);

	}

	public PlanItem searchPlan(String strDate) throws ParseException{
		Date date = PlanItem.getDateFromString(strDate);
		return planMap.get(date);
	
	}

	public static boolean isLeapYear(int year) {
		if ((year % 4 == 0) && (year % 100 != 0 || year % 400 == 0))
			return true;
		else
			return false;
	}

	public static int getMaxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAPmaxDays[month - 1];
		} else {
			return maxDays[month - 1];
		}
	}

	// Calendar1 project처럼 첫 요일을 입력받을 필요 없이 정밀한 달력을 출력할 수 있다.
	public int getWeek(int year, int month, int day) {
		int sYear = 1970;
		int sWeek = 4;
		int count = 0;

		for (int i = sYear; i < year; i++) {
			int delimiter = isLeapYear(i) ? 366 : 365;
			count = count + delimiter;
		}

		for (int i = 1; i < month; i++) {
			int delimiter = getMaxDaysOfMonth(year, i);
			count = count + delimiter;
		}
		count = count + day - 1;

		int weekday = (sWeek + count) % 7;

		return weekday;
	}

	public void printCalendar(int year, int month, int weekday) {
		System.out.println();

		System.out.printf("   << %4d년%3d월 >>\n", year, month);

		System.out.println();
		System.out.println("----------------------");
		System.out.println(" SU MO TU WE TH FR SA ");
		System.out.println("----------------------");

		for (int i = 0; i < weekday; i++) {
			System.out.print("   ");
		}

		int maxday = getMaxDaysOfMonth(year, month);

		// 삼항연산자 조건문을 통해 두번째줄부터의 출력을 구현함.

		int count = 7 - weekday;
		int deli = (count < 7) ? count : 0;
		for (int i = 1; i <= count; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();

		for (int j = count + 1; j <= maxday; j++) {
			System.out.printf("%3d", j);

			if (j % 7 == deli) {
				System.out.println();

			}

		}
		System.out.println();
		System.out.println("----------------------");
		System.out.println();
	}

}

// while(true)는 무한루프
