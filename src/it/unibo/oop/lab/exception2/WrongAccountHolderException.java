package it.unibo.oop.lab.exception2;

public class WrongAccountHolderException extends IllegalStateException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int usrID;

	public WrongAccountHolderException(int usrID) {
		super();
		this.usrID = usrID;
	}

	@Override
	public String toString() {
		return "WrongAccountHolderException [usrID=" + usrID + "]";
	}

	@Override
	public String getMessage() {
		return this.toString();
	}

}
