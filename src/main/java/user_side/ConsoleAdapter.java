package user_side;

import java.util.List;
import java.util.Scanner;

import business_logic.IRequestBank;

public class ConsoleAdapter {
	
	private IRequestBank request;
	private Scanner in = new Scanner(System.in);
	
	public ConsoleAdapter(IRequestBank request) {
		this.request = request;
	}
	
	public void Launch() {
		Menu();
	}
	
	private void Menu() {
		System.out.println("Hello, please choose the operation you want to perform.");
		System.out.println("Tap 1 to make a deposit");
		System.out.println("Tap 2 to make a withdrawal");
		System.out.println("Tap 3 to view your transaction history");
		System.out.println("Tap 4 to exit the menu");
		
		int choice = in.nextInt();
		
		switch(choice) {
			case 1:
				makeDeposit();
				break;
			case 2:
				makeWithdrawal();
				break;
			case 3:
				showHistory();
				break;
			case 4:
				System.out.println("Goodbye");
				System.exit(0);
			default:
				System.out.println("We did not understand your choice, please try again");
				break;
		}
		Menu();
	}
	
	private void makeDeposit() {
		System.out.println("Please enter the deposit amount");
		String msg = this.request.Deposit(in.nextDouble());
		System.out.println(msg);
	}
	
	private void makeWithdrawal() {
		System.out.println("Please enter the withdrawal amount");
		String msg = this.request.Withdrawal(in.nextDouble());
		System.out.println(msg);
	}
	
	private void showHistory() {
		System.out.println(this.request.GetHistory());
	}

}
