package sunyo.calendar;

public class Calendar {

	private static final int[] maxDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static int getMaxDaysOfMonth(int month) {
		return maxDays[month - 1];
	}

	public void printCalendar(int year, int month) {
		System.out.printf("   << %4d년%3d월 >>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA ");
		System.out.println("----------------------");
		
		int maxday = getMaxDaysOfMonth(month);
		for(int i =1; i <=maxday; i++) {
			System.out.printf("%3d",i);
			if((i % 7) == 0) {
				
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		printCalendar(2020, 3);
	}
}

//System.out.println(" 1    2   3    4    5    6     7");
//System.out.println(" 8   9   10  11   12  13  14");
//System.out.println("15  16  17  18  19  20  21");
//System.out.println("22  23  24  25  26  27  28");		

// 숫자를 입력받아 해당하는 달의 최대 일수를 출력하는 프로그램

//		Scanner scanner = new Scanner(System.in);
//		System.out.println("반복횟수를 입력하세요");
//		int repeat = scanner.nextInt();

//		for (int i=0; i < repeat; i++) {
//			System.out.println("달을 입력하세요");
//			System.out.print(PROMPT);
//			int month = scanner.nextInt();
//			System.out.printf("%d월은 %d일까지 있습니다.\n", month, cal.getMaxDaysOfMonth(month));
//		}
//		System.out.println("END.");
//		
// while(true)는 무한루프
