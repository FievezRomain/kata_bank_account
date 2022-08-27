package business_logic;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Account {
	private int id;
	private double amount;
	private List<Operation> history = new ArrayList<Operation>();
	
	public Account(int id) {
		this.id = id;
	}
	
	public double Withdrawal(double amount) {
		this.amount = this.amount - amount;
		this.newEvent("Withdrawal", amount);
		return this.amount;
	}
	
	public double Deposit(double amount) {
		this.amount = this.amount + amount;
		this.newEvent("Deposit", amount);
		return this.amount;
	}
	
	private void newEvent(String operationType, double amount) {
		Operation ope = new Operation(LocalDateTime.now(), operationType, amount);
		history.add(0, ope);
	}
	
}
