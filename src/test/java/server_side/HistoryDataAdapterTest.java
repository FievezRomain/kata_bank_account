package server_side;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import business_logic.Operation;
import junit.framework.TestCase;

public class HistoryDataAdapterTest extends TestCase {
	private HistoryDataAdapter historyData;
	
	@Before
	public void setUp() {
		historyData = new HistoryDataAdapter();
	}
	
	@Test
	public void testInsertEvent() {
		Operation ope = new Operation(LocalDateTime.now(), "Deposit", 10, "Test");
		historyData.insertEvent(ope);
		assertEquals(1, this.historyData.getNbEvent());
	}
}
