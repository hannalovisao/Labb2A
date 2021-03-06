import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new Scania());

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                car.move();
                int x = (int) Math.round(car.getPos().getX());
                int y = (int) Math.round(car.getPos().getY());
                frame.drawPanel.moveit(x, y, frame.drawPanel.volvoPoint);
                frame.drawPanel.moveit(x, 100, frame.drawPanel.saabPoint);
                frame.drawPanel.moveit(x,200, frame.drawPanel.scaniaPoint);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();


                if(atEndOfFrame(car)){
                    car.stopEngine();
                    car.turnRight();
                    car.turnRight();
                    car.gas(1);

                }


            }
        }
    }

    private boolean  atEndOfFrame(Car car){
        return ((car.getPos().x >= frame.drawPanel.getWidth()-frame.drawPanel.volvoImage.getWidth()
                && car.getDirection()== 0) ||
                (car.getPos().x <= 0 && car.getDirection() == 180)) ;

    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    void brake(int amount){
        double brake = ((double) amount) / 100;
        for (Car car : cars){
            car.brake(brake);
        }
    }



}