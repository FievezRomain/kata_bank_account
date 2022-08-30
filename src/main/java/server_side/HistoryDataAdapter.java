package server_side;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import business_logic.IObtainResponse;
import business_logic.Operation;

public class HistoryDataAdapter implements IObtainResponse {
	
	private List<Operation> history;
	
	public HistoryDataAdapter() {
		this.history = new ArrayList<Operation>();
	}

	public void insertEvent(Operation ope) {
		this.history.add(0, ope);
	}
	
	public int getNbEvent() {
		return this.history.size();
	}

	public String getHistory() {
		return this.toString();
	}
	
	public String toString() {
		String historyString = "";
		for(Operation elem : history) {
			historyString += MessageFormat.format("Operation type : {0}\n Amount : {1}\n Timestamp : {2} \n Comment : {3} \n", new Object[] {elem.getOperationType(), elem.getAmount(), elem.getTimestamp(), elem.getComment()});
		}
		return historyString;
	}

}
