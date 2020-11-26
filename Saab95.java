import java.awt.Color;

/**
 * @author hannaolsson A subclass to Car representing a Saab95
 */
public class Saab95 extends Car implements Turbo{
	/**
	 * Instance variable turboOn
	 */
	private boolean turboOn;

	/**
	 * sets turboOn to false, nrDoors to 2, color to red, enginePower to 125,
	 * modelName to Saab95 and calls stopEngien
	 */
	public Saab95() {
		super(2, 125, Color.red, "Saab95", 500);
		this.turboOn = false;
	}

	/**
	 * Gets the speedFactor
	 */
	public double speedFactor() {
		double turbo = 1;
		if (turboOn)
			turbo = 1.3;
		return enginePower * 0.01 * turbo;
	}


	public boolean getTurboOn() {
		return this.turboOn;
	}


	@Override
	public void turnOfTurbo() {
		this.turboOn = false;

	}

	@Override
	public void turnOnTurbo() {
		this.turboOn = true;

	}
}


