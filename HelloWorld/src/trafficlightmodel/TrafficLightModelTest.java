package trafficlightmodel;

import org.junit.Test;

import junit.framework.TestCase;

public class TrafficLightModelTest extends TestCase {

	@Test
	public void testNewTrafficLight() {
		TrafficLightModel a = new TrafficLightModel();
		assertEquals(true, a.getRed());
		assertEquals(false, a.getYellow());
		assertEquals(false, a.getGreen());		
		
	}

}
