package calculator;
import java.util.Scanner;
public class calculator {

	public static void main(String[] args) {
		int x = 0;
		int runs = 0;
		double total = 0;
		double input = 0;
		String operation = null;
		Scanner in = new Scanner(System.in);
		Scanner in2 = new Scanner(System.in);
		loop: while(x == 0)
		{
		
			if(runs > 0)
			{
				System.out.print("Enter Operation (+, -, *, /, or =): ");
				operation = in2.nextLine();
				
			}
			if(operation != "=") {
			System.out.print("Enter Number: ");
			input = in.nextDouble();
			}
			
			if(runs > 0)
			{
			switch(operation)
				{
				case "+": total += input;
						break;
				case "-": total -= input;
						break;
				case "*": total *= input;
						break;
				case "/": total /= input;
						break;
				case "=": x = 1;
						break loop;
			
				default: System.out.println("Invalid Operation, Try Again.");
				break;
			
				}
			}
		
		
			else if(runs == 0)
			{
				total += input;
			}
		
			System.out.println("Total is now: " + total);
			runs++;
		
		
		}
		System.out.println("Ending total is: " + total);
		
	}
}


