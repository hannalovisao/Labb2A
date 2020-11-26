import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hannaolsson A class that models a car transport
 *
 */
public class CarTransport extends Car {
	/**
	 * A boolean to keep track of whether the platform is up or down
	 */
	private boolean platformIsDown;

	private Loader<Car> carLoader;

	/**
	 * @param maxCars he max numer of cars that can be loaded on the transport
	 *                creates an instance of a car, makes carsOnTransport a
	 *                reference to a new ArrayList, the platform is up
	 */
	public CarTransport(int maxCars) {
		super(2, 400, Color.YELLOW, "Transport", 3000);
		carLoader = new Loader<Car>(maxCars, false);
		this.platformIsDown = false;

	}

	/**
	 * @return how many cars are on the transport
	 */
	public int nrCarsOnTransport() {
		return carLoader.sizeOfThingsLoaded();
	}

	/**
	 * @return true if the platform is down
	 */
	public boolean isThePlatformDown() {
		return this.platformIsDown;
	}

	/**
	 * @param car the car that you want to load on the transport A transport can not
	 *            be loaded on the transport A car can only be loaded if there is
	 *            room on the transport A car can oly be loaded of the platform is
	 *            down A car can oly be loaded if it is "near" the transport The
	 *            loaded car gets the position of the transport
	 */
	public void loadCar(Car car) {

		if (!tooBig(car) && platformIsDown && isNear(car) && !car.getIsLoaded()) {
			carLoader.load(car);
			car.setIsLoaded(true);
			if (isOnTransport(car)) {
				car.setPos(getPos());
			}
		} else {
			System.out.println(
					"Error in loadCar, the problem might be:\n 1) The car is to far away from the transport \n 2) The transport can only load cars when the platform is down \n 3) This Transport can only load "
							+ carLoader.getCapacity() + " cars \n 4) You cant load the transport with a transport");
		}

	}

	/**
	 * The car that is unloaded is the car that was most reacently loaded The car
	 * gets a position near the transport
	 */
	public void unloadCar() {
		if (platformIsDown) {
			Car lastCar = carLoader.getLastThing();
			carLoader.unLoad();
			Point2D.Double posNearTransport = new Point2D.Double((getPos().x + 1), (getPos().y + 1));

			lastCar.setPos(posNearTransport);
			lastCar.setIsLoaded(false);
		}

	}

	/**
	 * @param car the car that may or may not be near the transport
	 * @return true if the car is within radius 1 of the transport
	 */
	public boolean isNear(Car car) {
		return ((car.getPos().x < (getPos().x + 1) && car.getPos().x > (getPos().x - 1))
				&& (car.getPos().y < (getPos().y + 1) && car.getPos().y > (getPos().y - 1)));

	}

	/**
	 * The platform can only be lowered if the speed of the transport is 0
	 */
	public void lowerPlatform() {
		if (getCurrentSpeed() == 0) {
			platformIsDown = true;
		} else {
			System.out.println("Error in lowerPlatform: you cant lower platform while the transport moves");
		}

	}

	/**
	 * The platform can only be raised if the speed of the transport is 0
	 */
	public void raisePlatform() {
		if (getCurrentSpeed() == 0) {
			platformIsDown = false;
		} else {
			System.out.println("Error in raisePlatform: you cant raise platform while the transport moves");
		}

	}

	/**
	 * Speedfactor of the transport
	 */
	@Override
	protected double speedFactor() {
		return enginePower * 0.01;
	}

	/**
	 * The transport can only move if the platform is up
	 */
	@Override
	public void move() {
		if (!platformIsDown) {
			super.move();
		} else {
			System.out.println("Error in move: The platform must be up when the transport moves");
		}

	}

	/**
	 * @param car the car that mwy or may not be on the tarnsport
	 * @return true if the car is on the transport
	 */
	public boolean isOnTransport(Car car) {
		if (carLoader.getThingsLoaded().contains(car)) {
			return true;
		} else
			return false;
	}

	public boolean tooBig(Car car) {
		return car.getWeight() > getWeight();
	}

}