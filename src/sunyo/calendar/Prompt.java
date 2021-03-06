package sunyo.calendar;

import java.util.Scanner;

public class Prompt {

	public int parseDay(String str_weekday) {

		switch (str_weekday) {
		case "su":
			return 0;
		case "mo":
			return 1;
		case "tu":
			return 2;
		case "wd":
			return 3;
		case "th":
			return 4;
		case "fr":
			return 5;
		case "sa":
			return 6;
		default :
			return 0;
		}

	}

	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		int month;
		int year;
		int weekday;

		while (true) {
			System.out.println("년도를 입력하세요");
			System.out.print("YEAR > ");
			year = scanner.nextInt();
			System.out.println("달을 입력하세요");
			System.out.print("MONTH > ");
			month = scanner.nextInt();
			System.out.println("첫째 날의 요일을 입력하세요(su, mo, tu, wd, th, fr, sa).");
			System.out.print("WEEKDAY > ");
			String str_weekday = scanner.next();
			weekday = parseDay(str_weekday);

			if (month < 1) {
				System.out.println("숫자가 1 보다 작으면 종료됩니다. ");
				break; // break를 만나면 반복이 종료된다.
			}

			if (month > 12) {
				System.out.println("12 이하의 숫자만 입력하세요. ");
				continue; // continue는 처음으로 되돌아간다.
			}
			cal.printCalendar(year, month, weekday);
			System.out.println();

		}
		System.out.println("bye~");
		scanner.close();
	}

	public static void main(String[] args) {
		Prompt p = new Prompt();
		p.runPrompt();

	}

}
