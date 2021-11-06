package it.unibo.oop.lab.exception1;

public class NotEnoughBatteryException extends IllegalStateException{

	/**
	 * Using IllegalStateException is because this is an expected(checked) error
	 * it happens quite often, and shouldn't be a runtimeException
	 */
	private static final long serialVersionUID = 1L;
	private final double batteryLevel;
	private final double MOVEMENT_DELTA_CONSUMPTION;
	
	 /**
     * Construct new instance of the exception.
     * 
     * @param batteryLevel
     *            current battery level
     * @param MOVEMENT_DELTA_CONSUMPTION
     *            the batteryLevel is not enough for the consumption
     */
	
	public NotEnoughBatteryException(double batteryLevel, double mOVEMENT_DELTA_CONSUMPTION) {
		super();
		this.batteryLevel = batteryLevel;
		MOVEMENT_DELTA_CONSUMPTION = mOVEMENT_DELTA_CONSUMPTION;
	}

	@Override
	public String toString() {
		return "Low Battery: [batteryLevel=" + batteryLevel + ", MOVEMENT_DELTA_CONSUMPTION="
				+ MOVEMENT_DELTA_CONSUMPTION + "] is not enough to complete the action";
	}

	@Override
	public String getMessage() {
		return this.toString();
	}
	
	
	
	
	
}
