package business_logic;

import java.time.LocalDateTime;

public class Operation {
	private LocalDateTime timestamp;
	private String operationType;
	private double amount;
	private String comment;
	
	public Operation(LocalDateTime timestamp, String operationType, double amount, String comment) {
		this.timestamp = timestamp;
		this.operationType = operationType;
		this.amount = amount;
		this.comment = comment;
	}
	
	public LocalDateTime getTimestamp() {
		return this.timestamp;
	}
	
	public String getOperationType() {
		return this.operationType;
	}
	
	public double getAmount() {
		return this.amount;
	}
	
	public String getComment() {
		return this.comment;
	}
}
