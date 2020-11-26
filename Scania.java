import java.awt.Color;

/**
 * @author hannaolsson
 * A class that models a Scania truck 
 *
 */
public class Scania extends Car implements IPlatform {

	/**
	 * Scania has a platform
	 */
	//private Platform platform;

	private double angle;

	/**
	 * Creates an instance of a car, makes platform a reference to a new Platform
	 */
	public Scania() {
		super(2, 250, Color.BLUE, "Scania", 2000);
		//platform = new Platform();
		this.angle = 0;

	}

	/**
	 * @param amount the amount you want to raise the platform with 
	 * The platform can only be raised if the truck is still 
	 */


	/**
	 * @param amount the amount you want to lower the platform with
	 *               The platform can only be lowered if the truck is still
	 */

	/**
	 * The truck can only move of the platform has a 0 angle
	 */
	@Override
	public void move() {
		if (this.angle == 0) {
			super.move();
		} else {
			System.out.println("Error in move: The angel of the platform must be 0 when the truck moves");
		}

	}

	/**
	 * speedFactor of the truck
	 */
	protected double speedFactor() {
		return enginePower * 0.01;
	}

	@Override
	public void lowerPlatform(double amount) {
		if (getCurrentSpeed() == 0) {
			if (angle - amount >= 0) {
				this.angle = angle - amount;
			} else {
				angle = 0;
				System.out.println(
						"Error in lowerPlattform: You have tried to lower the platform beyond its capacity, the angle is now 0 degrees");
			}
		}

		else{
				System.out.println("Error in raisePlattform: You can't raise the plattform while the truck moves.");
			}

	}

	@Override
	public void raisePlatform(double amount) {
		if (getCurrentSpeed() == 0) {
			if (angle + amount <= 70) {
				this.angle = angle + amount;
			} else {
				angle = 70;
				System.out.println(
						"Error in raisePlattform: You have tried to raise the platform beyond its capacity, the angle is now 70 degrees");
			}

		} else {
			System.out.println("Error in lowerPlattform: You can't lower the plattform while the truck moves.");
		}

	}
}
