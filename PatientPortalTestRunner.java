//package de.vogella.junit.first;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
/**
 * PatientPortalTestRunner runs PatientPortalTest and sees if there were any problem where received when
 * testing PatientPortal using JUnit to get the amount of failures assuming there are any.
 * <p>
 *
 * @return Whether or not any units tests failed.
 */
public class PatientPortalTestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(PatientPortalTest.class);
        if (result.getFailures().size() > 0) {
            System.err.println("A unit test failed:");
            for (Failure failure: result.getFailures()) {
                System.err.println("t" + failure.toString());
            }
            System.exit(1);
        }
        System.out.println("No errors detected in run.");
        System.exit(1);
    }
}
