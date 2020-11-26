import java.util.ArrayList;
import java.util.List;

/**
 * @author hannaolsson
 * 
 *         This class models a service station for cars. Some servic stations
 *         will be able to take in all types of cars while other only will take
 *         in a special type of car
 *
 * @param <T> This class has a type parameter T that can be any of the
 *            subclasses of Car
 */
public class ServiceStation<T extends Car> {

	/**
	 * A list where you keep track of the cars that are in the service station
	 */
	private List<T> carsInService;
	/**
	 * The maximun numer of cars that a service station can take in
	 */
	private int maxCars;

	/**
	 * @param maxCars the maximun numer of cars that a service station can take in
	 *                sets maxCars to the parameter value maxCars and sets
	 *                carsInService to a new ArrayList
	 */
	public ServiceStation(int maxCars) {
		this.carsInService = new ArrayList<T>();
		this.maxCars = maxCars;
	}

	/**
	 * @return the list carsInService
	 */
	public List<T> getCarsInService() {
		return carsInService;
	}

	/**
	 * @param car the car that you want to submit to the service station You can oly
	 *            submit a car if there is room in the service station
	 */
	public void submitCar(T car) {
		if (carsInService.size() < maxCars) {

			carsInService.add(car);
		} else {
			System.out.println("Error in submitCar: This service station can only submit " + maxCars + " cars");
		}
	}

	/**
	 * @param car the car that you want to pick up from the service station
	 */
	public void pickUpCar(T car) {
		carsInService.remove(car);
	}

}
