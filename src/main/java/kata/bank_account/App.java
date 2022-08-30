package kata.bank_account;

import business_logic.IObtainResponse;
import business_logic.IRequestBank;
import business_logic.OperationReader;
import server_side.HistoryDataAdapter;
import user_side.ConsoleAdapter;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	// 1. Instantiate right-side adapter(s) ("I want to go outside the hexagon")
        IObtainResponse dataAdapter = new HistoryDataAdapter();

        // 2. Instantiate the hexagon
        IRequestBank operationReader = new OperationReader(dataAdapter);

        // 3. Instantiate the left-side adapter(s) ("I want ask/to go inside the hexagon")
        ConsoleAdapter consoleAdapter = new ConsoleAdapter(operationReader);
        consoleAdapter.Launch();
    }
}
