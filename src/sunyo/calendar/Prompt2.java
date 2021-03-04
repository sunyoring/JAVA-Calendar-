package sunyo.calendar;

import java.util.Scanner;

public class Prompt2 {

	public void printMenu() {
		System.out.println("+----------------+");
		System.out.println("| 1 . 일정 등록    |");
		System.out.println("| 2 . 일정 검색    |");
		System.out.println("| 3 . 달력 보기    |");
		System.out.println("| 4 .  q, 종료    |");
		System.out.println("+----------------+");

	}

	public void runPrompt() {
		printMenu();

		Scanner scanner = new Scanner(System.in);
		Calendar2 cal = new Calendar2();

		while (true) {			
			System.out.println("명령(1, 2, 3, h, q)");			
			String cmd = scanner.next();
			if (cmd.equals("1")) cmdRegister();				
			else if (cmd.equals("2")) cmdSearch();				
			else if (cmd.equals("3")) cmdCal(scanner, cal);				
			else if (cmd.equals("h")) printMenu();		
			else if (cmd.equals("q")) break; }
						
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

		c.printCalendar(year, month, c.getWeek(year, month, 1));
		


	}

	private void cmdSearch() {
		// TODO Auto-generated method stub

	}

	private void cmdRegister() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		Prompt2 p = new Prompt2();
		p.runPrompt();

	}

}
