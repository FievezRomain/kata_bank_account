package business_logic;

import java.util.List;

public interface IRequestBank {
	public String Deposit(double amount);
	public String Withdrawal(double amount);
	public String GetHistory();
}
