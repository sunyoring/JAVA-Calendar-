package sunyo.calendar;

import java.util.Scanner;

public class Prompt {

	private final static String PROMPT = "cal > ";

	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		int month;
		while (true) {
			System.out.println("달을 입력하세요");
			System.out.print(PROMPT);
			month = scanner.nextInt();

			if (month < 1) {
				System.out.println("숫자가 1 보다 작으면 종료됩니다. ");
				break; 			// break를 만나면 반복이 종료된다.
			}

			if (month > 12) {
				System.out.println("12 이하의 숫자만 입력하세요. ");
				continue; 			// continue는 처음으로 되돌아간다.		
			}
				cal.printCalendar(2021, month);
				System.out.println();
				System.out.println();
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
