package business_logic;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import server_side.HistoryDataAdapter;

public class OperationReaderTest extends TestCase {
	private OperationReader operationReader;
	private IObtainResponse historyData;
	
	@Before
	public void setUp() {
		historyData = new HistoryDataAdapter();
		operationReader = new OperationReader(historyData);
	}
	
	@Test
	public void testDeposit() {
		operationReader.Deposit(100.5);
		assertEquals(100.5, operationReader.getAccount().getAmount());
	}
	
	@Test
	public void testWithdrawal() {
		operationReader.Deposit(100.1);
		operationReader.Withdrawal(10.1);
		assertEquals(90.0, operationReader.getAccount().getAmount());
	}
}
