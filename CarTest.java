import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.awt.geom.Point2D;


class CarTest {
	
	
	Volvo240 v = new Volvo240();
	
	CarTransport t = new CarTransport(2);
	
	CarFerry cf = new CarFerry();
	
	Scania s = new Scania();
	
	
	
	@Test
	void canTheCarTurn() {
		int dir = v.getDirection(); 
 	v.turnLeft();
		assertTrue(dir != v.getDirection());
	}
	
	@Test
	void canTheCarGas() {
		double speed = v.getCurrentSpeed();
		v.gas(0.5);
		assertTrue(speed != v.getCurrentSpeed());
	}
	
	@Test
	void canTheTransportLowerPlatform() {
		boolean upOrDown = t.isThePlatformDown();
		t.lowerPlatform();
		assertTrue(upOrDown != t.isThePlatformDown());
	}
	
	
	@Test
	void canTheFerryLoadCars() {
		int firstSize = cf.nrCarsOnFerry();
		cf.load(v);
		assertTrue(firstSize != cf.nrCarsOnFerry());
	}
	
	
	@Test
	void canTheTransportLoadWhilePlatformIsUp() {
		t.loadCar(v);
		assertTrue(t.nrCarsOnTransport() != 1);
	}
	
	@Test
	void canScaniaGas () {
		double startSpeed = s.getCurrentSpeed();
		s.gas(0.8);
		assertTrue(startSpeed != s.getCurrentSpeed());
	}
	
	@Test
    public void testSetandGetColor() {
        v.setColor(Color.blue);
        assertEquals(Color.blue, v.getColor());
    }

    @Test
    public void testGetModelName() {
        assertEquals("Volvo240", v.getModelName());
    }

    @Test
    public void testStartEngine() {
        v.startEngine();
        assertEquals(0.1, v.getCurrentSpeed(), 0);
    }

    @Test
    public void testStopEngine() {
        v.startEngine();
        v.stopEngine();
        assertEquals(0, v.getCurrentSpeed(), 0);
    }

    @Test
    public void testTurnLeft() {
        for (int i=0; i<4; i++)
            v.turnLeft();
        assertEquals(0, v.getDirection());
    }

    @Test
    public void testTurnRight() {
        v.turnLeft();
        for (int i=0; i<2; i++)
            v.turnRight();
        assertEquals(270, v.getDirection());
    }


    @Test
    public void testMove() {
        for (int i=0; i<3; i++) {
            for (int j=0; j<i; j++) {
                v.turnLeft();
            }
            v.move();
            assertTrue(v.getPos() != new Point2D.Double(0,0));
        }
    }

    @Test
    public void testGasansBrake() {
        double speedStart = v.getCurrentSpeed();
        v.gas(0.5);
        double speedMax = v.getCurrentSpeed();
        assertTrue(speedStart < speedMax);

        v.brake(0.2);
        assertTrue(v.getCurrentSpeed() < speedMax);

        v.gas(0.5);
        v.brake(0.5);
    }
	

	
	

	
	
	

	
	

}
