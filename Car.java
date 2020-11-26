import java.awt.*;
import java.awt.geom.Point2D;

/**
 * @author hannaolsson This is a class representing a car
 */

public abstract class Car extends Vehicle{
	
	/**
	 * Number of doors on the car
	 */
	private int nrDoors;
	
	private boolean isLoaded;

	public Car(int doors, double enginePower, Color color, String modelName, double weight) {
		super(enginePower, color, modelName, weight);
		this.nrDoors = doors; 
		this.isLoaded = false;
		
	}


	/**
	 * @return the number of doors of the car
	 */
	public int getNrDoors() {
		return nrDoors;
	}

	
	public boolean getIsLoaded() {
		return isLoaded;
	}
	
	public void setIsLoaded(boolean loaded) {
		this.isLoaded = loaded; 
	}


}
