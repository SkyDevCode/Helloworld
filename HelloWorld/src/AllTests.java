import junit.framework.Test;
import junit.framework.TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

public class AllTests {
	
	public static Test suite() {
		TestSuite suite = new TestSuite("Test for default package");
		
		//$Junit-BEGIN$
		suite.addTestSuite(CalculatorTest.class);
		//$JUnit-END$
		return suite;
		
	}
}
