package business_logic;

import java.util.List;

public interface IRequestBank {
	public double Deposit(int id, double amount);
	public double Withdrawal(int id, double amount);
	public List<Object> GetHistory();
}
