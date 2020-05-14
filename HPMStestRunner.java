import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
//Runs the HPMStest.java to test the methods of HPMS
public class HPMStestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(HPMStest.class);
        if (result.getFailures().size() > 0) {
            System.err.println("A unit test failed:");
            for (Failure failure: result.getFailures()) {
                System.err.println("\t" + failure.toString());
            }
            System.exit(1);
        }
        System.out.println("All tests passed");
        System.exit(0);
    }
}