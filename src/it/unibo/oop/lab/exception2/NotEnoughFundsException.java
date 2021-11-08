package it.unibo.oop.lab.exception2;

public class NotEnoughFundsException extends IllegalStateException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final double funds;

	public NotEnoughFundsException(double amount) {
		super();
		this.funds = amount;
	}

	@Override
	public String toString() {
		return "NotEnoughFundsException [funds=" + funds + "]";
	}

	@Override
	public String getMessage() {
		return this.toString();
	}

}
