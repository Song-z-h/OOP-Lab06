package it.unibo.oop.lab.exception2;

public class TransactionsOverQuotaException extends IllegalStateException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int currentTransactionCount;
	private final int maximumTransactionAllowed;
	public TransactionsOverQuotaException(int currentTransactionCount, int maximumTransactionAllowed) {
		super();
		this.currentTransactionCount = currentTransactionCount;
		this.maximumTransactionAllowed = maximumTransactionAllowed;
	}
	@Override
	public String toString() {
		return "TransactionsOverQuotaException [currentTransactionCount=" + currentTransactionCount
				+ ", maximumTransactionAllowed=" + maximumTransactionAllowed + "]";
	}
	@Override
	public String getMessage() {
		return this.toString();
	}
	
	
	
}
