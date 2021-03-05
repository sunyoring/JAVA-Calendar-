package sunyo.calendar;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt2 {

	public void printMenu() {
		System.out.println("+----------------+");
		System.out.println("| 1 . 일정 등록    |");
		System.out.println("| 2 . 일정 검색    |");
		System.out.println("| 3 . 달력 보기    |");
		System.out.println("| 4 .  q, 종료    |");
		System.out.println("+----------------+");
		System.out.println("명령(1, 2, 3, h, q)");
	}

	public void runPrompt() throws ParseException {
		printMenu();

		Scanner scanner = new Scanner(System.in);
		Calendar2 cal = new Calendar2();

		// if-else-if로 구현

//		while (true) {
//			String cmd = scanner.next();
//			if (cmd.equals("1"))
//				cmdRegister(scanner, cal);
//			else if (cmd.equals("2"))
//				cmdSearch(scanner, cal);
//			else if (cmd.equals("3"))
//				cmdCal(scanner, cal);
//			else if (cmd.equals("h"))
//				printMenu();
//			else if (cmd.equals("q"))
//				break;
//		}

		// switch-case로 구현
		boolean isLoop = true;
		while (isLoop) {
			String cmd = scanner.next();
			switch (cmd) {
			case "1":
				cmdRegister(scanner, cal);
				break;
			case "2":
				cmdSearch(scanner, cal);
				break;
			case "3":
				cmdCal(scanner, cal);
				break;
			case "h":
				printMenu();
				break;
			case "q":
				isLoop = false;
				break;
			}
		}

		System.out.println("Thank you. Bye~");
		scanner.close();
	}

	private void cmdCal(Scanner s, Calendar2 c) {

		int month;
		int year;

		System.out.println("년도를 입력하세요");
		System.out.print("YEAR > ");
		year = s.nextInt();

		System.out.println("달을 입력하세요");
		System.out.print("MONTH > ");
		month = s.nextInt();

		if (month < 1 || 12 < month) {
			System.out.println("잘못된 입력입니다.");
		} else {
			c.printCalendar(year, month, c.getWeek(year, month, 1));
		}

	}

	private void cmdRegister(Scanner s, Calendar2 c) throws ParseException {
		System.out.println("[새 일정 등록]");
		System.out.println("날짜를 입력해 주세요. (YYYY-MM-DD)");
		String date = s.next();
		s.nextLine();
		System.out.println("일정을입력해 주세요.");
		String text = s.nextLine();
		c.registerPlan(date, text);

	}

	private void cmdSearch(Scanner s, Calendar2 c) throws ParseException {
		System.out.println("[일정 검색]");
		System.out.println("날짜를 입력해 주세요. (YYYY-MM-DD)");
		String date = s.next();
		PlanItem plan;
		plan = c.searchPlan(date);

		if (plan != null) {
			System.out.println(plan.detail);
		} else {
			System.out.println("일정이 없습니다. ");
		}

	}

	public static void main(String[] args) throws ParseException {
		Prompt2 p = new Prompt2();
		p.runPrompt();

	}

}
