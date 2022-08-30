package business_logic;

import java.time.LocalDateTime;
import java.util.List;

public class OperationReader implements IRequestBank {
	
	private Account account;
	private IObtainResponse historyData;
	
	public OperationReader(IObtainResponse historyData) {
		this.historyData = historyData;
		this.account = new Account();
	}
	
	/**
	 * @author FIEVEZ
	 * @param amount : The amount of the deposit (double)
	 * @return : Status of the operation (String)
	 * Deposits money into the account using the Deposit method and collects the message in return. 
	 * Creates an event to keep track of the transactions and returns the status of the transaction.
	 */
	public String Deposit(double amount) {
		String msg = this.account.Deposit(amount);
		createEvent("Deposit", amount, msg);
		return msg;
	}

	/**
	 * @author FIEVEZ
	 * @param amount : The amount of the withdrawal (double)
	 * @return : Status of the operation (String)
	 * Withdraw the money of the account using the Withdrawal method and collects the message in return. 
	 * Creates an event to keep track of the transactions and returns the status of the transaction.
	 */
	public String Withdrawal(double amount) {
		String msg = this.account.Withdrawal(amount);
		createEvent("Withdrawal", amount, msg);
		return msg;
	}

	
	/**
	 * @author FIEVEZ
	 * @return : The history in a String
	 * Returns the transaction history of the account
	 */
	public String GetHistory() {
		return this.historyData.getHistory();
	}
	
	/**
	 * @author FIEVEZ
	 * @param type : Type of operation (deposit or withdrawal)
	 * @param amount : The amount of the operation
	 * @param comment : Status of the operation
	 * Creating an event and adding it to the server side storage
	 */
	public void createEvent(String type, double amount, String comment) {
		Operation ope = new Operation(LocalDateTime.now(), type, amount, comment);
		this.historyData.insertEvent(ope);
	}
	
	public Account getAccount() {
		return this.account;
	}
}
