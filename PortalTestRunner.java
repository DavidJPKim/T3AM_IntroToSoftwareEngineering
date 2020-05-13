//package de.vogella.junit.first;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
* This is the test runner file for Portal.java. It runs all tests in PortalTest.
* <p>
* This method does not return any values. It either prints errors to the 
* System.error stream or that no errors were detected to the System.out stream.
*
* @param  Result result: A result variable used to run PortalTest.
* @return Returns nothing.
*/

public class PortalTestRunner {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(PortalTest.class);
		
			if (result.getFailures().size() > 0){
    		System.err.println("A unit test failed:");
        		for (Failure failure : result.getFailures()) {
            	System.err.println("\t" + failure.toString());
        		}
        	System.exit(1);
    		}
    	System.out.println("No errors detected in run.");
    	System.exit(1);
	}
}
