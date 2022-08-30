package business_logic;

import java.text.MessageFormat;

public class Account {
	private double amount;
	
	public Account() {
		this.amount = 0;
	}
	
	/**
	 * @author FIEVEZ
	 * @param amount : Amount of the operation
	 * @return String : Status of the operation
	 * Checks whether the amount to be withdrawn is available in the account. 
	 * If yes, it is withdrawn and the status is returned as successful, otherwise a rejection message is sent.
	 */
	public String Withdrawal(double amount) {
		if(this.amount >= amount) {
			this.amount = this.amount - amount;
			return MessageFormat.format("You have withdrawn {0} euros from your account. Your new balance is {1} euros", new Object[] {amount, this.amount});
		}
		return MessageFormat.format("Your balance is {0}. You cannot withdraw {1} euros.",  new Object [] {this.amount, amount});
	}
	
	/**
	 * @author FIEVEZ
	 * @param amount : Amount of the operation
	 * @return String : Status of the operation
	 * Checks that the amount is not negative. 
	 * If positive, the amount is deposited, otherwise a rejection message is sent.
	 */
	public String Deposit(double amount) {
		if(amount > 0) {
			this.amount = this.amount + amount;
			return MessageFormat.format("You have deposited {0} euros. Your new balance is {1} euros.", new Object [] {amount, this.amount});
		}
		return "An error occurred while entering the sum, please try again.";
	}
	
	public double getAmount() {
		return this.amount;
	}
}
