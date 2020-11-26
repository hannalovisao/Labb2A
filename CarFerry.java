import java.awt.Color;

/**
 * @author hannaolsso
 * A class modeling a Ferry that can transport cars 
 *
 */
public class CarFerry extends Vehicle{
	
	/**
	 * carLoader only stores Cars 
	 */
	private Loader <Car> carLoader;

	/**
	 * The ferry unlods cars according to fifo 
	 */
	public CarFerry() {
		super(400, Color.WHITE, "CarFerry", 10000);
		this.carLoader = new Loader<Car>(50, true);
	}
	
	/**
	 * @return number of boats on the ferry
	 */
	public int nrCarsOnFerry() {
		return carLoader.sizeOfThingsLoaded();
	}

	/**
	 * Speed factor
	 */
	@Override
	protected double speedFactor() {
		
		return enginePower * 0.01;
	}
	
	/**
	 * @param car the car to load 
	 */
	public void load(Car car) {
		carLoader.load(car);
	}
	
	/**
	 * unload according to fifo
	 */
	public void unLoad() {
		carLoader.unLoad();
	}
	
	

}
