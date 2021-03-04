package sunyo.calendar;

import java.util.Scanner;

public class Prompt2 {


	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calendar2 cal = new Calendar2();

		int month;
		int year;
		while (true) {
			System.out.println("년도를 입력하세요");			
			System.out.print("YEAR > ");
			year = scanner.nextInt();
			
			if (year < 1)
				break ;
						
			System.out.println("달을 입력하세요");			
			System.out.print("MONTH > ");
			month = scanner.nextInt();
			
			if (month < 1 || month > 12) {
				System.out.println("12 이하의 숫자만 입력하세요. ");
				continue; // continue는 처음으로 되돌아간다.
			}
	
			cal.printCalendar(year, month, cal.getWeek(year, month, 1));
			System.out.println();
		

		}
		System.out.println("bye~");
		scanner.close();
	}

	public static void main(String[] args) {
		Prompt2 p = new Prompt2();
		p.runPrompt();

	}

}
