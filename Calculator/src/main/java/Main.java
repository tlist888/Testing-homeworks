import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class Main {
    public static void main(String []args){

        SimpleGui app = new SimpleGui();
        app.setVisible(true);


        /*JUnitCore runner = new JUnitCore();
        Result result = runner.run(CalculatorTest.class);
        System.out.println("run tests: " + result.getRunCount());
        System.out.println("failed tests: " + result.getFailureCount());
        System.out.println("ignored tests: " + result.getIgnoreCount());
        System.out.println("success: " + result.wasSuccessful());*/
    }
}
