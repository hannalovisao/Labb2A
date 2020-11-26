import java.awt.Color;

public class Volvo240 extends Car {

	/**
	 * Class variable trimFactor = 1.25, shared by all objects
	 */
	private final static double trimFactor = 1.25;

	/**
	 * sets nrDoors to 4, color to black, enginePower to 100, modelName = Volvo240
	 * an stops the engine
	 */
	public Volvo240() {

		super(4, 100, Color.black, "Volvo240", 550);

	}

	/**
	 * Gets the speedFactor
	 */
	public double speedFactor() {
		return enginePower * 0.01 * trimFactor;
	}

}
