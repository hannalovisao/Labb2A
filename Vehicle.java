import java.awt.Color;
import java.awt.geom.Point2D;

/**
 * @author hannaolsson
 *
 */
public abstract class Vehicle implements Movable {
	/**
	 * Engine power of the vehicle
	 */
	protected double enginePower;

	/**
	 * The current speed of the vehicle
	 */
	private double currentSpeed;

	/**
	 * Color of the vehicle
	 */
	private Color color;

	/**
	 * The vehicle model name
	 */
	private String modelName;

	/**
	 * Position of the vehicle
	 */
	protected Point2D.Double pos;
	/**
	 * Direction of the car modeled as the unit circle. 0 = x-direction, 90 =
	 * y-direction, 180 = -x-axeln, 270 = -y-axeln
	 */
	protected int direction;
	
	private double weight;

	/**
	 * @param enginePower engine power of the vehicle
	 * @param color       color of the vehicle
	 * @param modelName   name of the model of the vehicle
	 * 
	 *                    sets the initial position to (0,0) and directon to 0 which
	 *                    is in the x-direction
	 */
	public Vehicle(double enginePower, Color color, String modelName, double weight) {

		this.enginePower = enginePower;
		this.color = color;
		this.modelName = modelName;
		this.weight = weight;

		pos = new Point2D.Double(0, 0);
		direction = 0;
		stopEngine();

	}
	
	public double getWeight() {
		return weight; 
	}

	/**
	 * @return the position of the car
	 */
	public Point2D.Double getPos() {
		return pos;
	}

	public void setPos(Point2D.Double pos) {
		this.pos = pos;

	}

	public void setDirection(int direction){
		this.direction = direction;
	}

	/**
	 * @return the direction of the vehicle
	 */
	public int getDirection() {
		return direction;
	}

	/**
	 * @return the engine power of the vehicle
	 */
	public double getEnginePower() {
		return enginePower;
	}

	/**
	 * @return the current speed of the vehicle
	 */
	public double getCurrentSpeed() {
		return currentSpeed;
	}

	/**
	 * @return the color of the vehicle
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param clr desiered color of the vehicle 
	 * Sets the color of the vehicle to the desiered color
	 */
	public void setColor(Color clr) {
		color = clr;
	}

	public String getModelName() {
		return modelName;
	}

	/**
	 * Sets the current speed to 0.1
	 */
	public void startEngine() {
		currentSpeed = 0.1;
	}

	/**
	 * Sets the current speed to 0
	 */
	public void stopEngine() {
		currentSpeed = 0;
	}

	/**
	 * @return the speedFactor
	 */
	protected abstract double speedFactor();

	private void incrementSpeed(double amount) {
		currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
	}

	/**
	 * Sets currentSpeed to getCurrentSpeed() - speedFactor() * amount
	 */
	private void decrementSpeed(double amount) {
		currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
	}

	/**
	 * Makes the vehicle move with the current speed in the direction of the car
	 */
	public void move() {
		if (direction == 0) {
			pos.x = (pos.x + getCurrentSpeed());
		} else if (direction == 90) {
			pos.y = (pos.y + getCurrentSpeed());
		} else if (direction == 180) {
			pos.x = (pos.x - getCurrentSpeed());
		} else if (direction == 270) {
			pos.y = (pos.y - getCurrentSpeed());

		}

	}

	/**
	 * makes the vehicle left (turn 90 degrees)
	 */
	public void turnLeft() {
		if (direction < 360) {
			direction = direction + 90;
			if (direction == 360) {
				direction = 0;
			}

		}

	}

	/**
	 * makes the vehicle turn right
	 */
	public void turnRight() {
		if (direction > 0) {
			direction = direction - 90;
		}

		else if (direction == 0) {
			direction = 270;
		}

	}

	/**
	 * @param amount the amount to gas makes te vehicle increment current speed
	 */
	public void gas(double amount) {
		if (amount >= 0 && amount <= 1) {
			incrementSpeed(amount);
		} else {
			System.out.println("Error in gas: You need to enter an amount between 0 and 1");
		}
	}

	/**
	 * @param amount the amount to brake makes the vehicle decremnt current speed
	 */
	public void brake(double amount) {
		if (amount >= 0 && amount <= 1) {
			decrementSpeed(amount);
		} else {
			System.out.println("Error in gas: You need to enter an amount between 0 and 1");
		}
	}

}
