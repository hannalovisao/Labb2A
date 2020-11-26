
/**
 * @author hannaolsson
 * A class that models a 
 */
public class Platform {

	/**
	 * The platform has an angle 
	 */
	private double angle;

	/**
	 * sets the angle to 0 
	 */
	public Platform() {
		this.angle = 0;
	}

	/**
	 * @param angle the angle that the platform will get
	 */
	public void zeroAngle() {
		setAngle(0);
	

	}
	
	private void setAngle(double angle) {
		this.angle = angle;
	}

	/**
	 * @return angle of the platform 
	 */
	public double getAngle() {
		return angle;
	}

	/**
	 * @param amount the amount to raise the platform with 
	 * Raising the platform is only possible if the angle after raising the platform is less than 70 
	 */
	public void raisePlatform(double amount) {
		if (angle + amount <= 70) {
			setAngle(angle + amount);
		} else {
			angle = 70;
			System.out.println(
					"Error in raisePlattform: You have tried to raise the platform beyond its capacity, the angle is now 70 degrees");
		}

	}

	/**
	 * @param amount the amount to lower the platform with 
	 * Lowering the platform is only possible if the angle after raising the platform is larger than 0 
	 */
	public void lowerPlatform(double amount) {
		if (angle - amount >= 0) {
			setAngle(angle - amount);
		} else {
			angle = 0;
			System.out.println(
					"Error in lowerPlattform: You have tried to lower the platform beyond its capacity, the angle is now 0 degrees");
		}
	}

}
