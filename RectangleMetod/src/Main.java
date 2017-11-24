import java.util.function.DoubleUnaryOperator;


public class Main {
    public static void main(String[] args) {
        System.out.println(integrate(x -> 1, 1, 10)); //integrate 1, x=1..10 = 9.0
        System.out.println(integrate(x -> x, 1, 10)); //integrate x, x=1..10 = 49.5
    }


    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        int i;
        double result = 0;
        double step = 0.1;

        int n = (int)((b - a) / step);

        for(i = 0; i < n; i++)
        {
            result += f.applyAsDouble(a + step * (i + 0.5));
        }

        result *= step;

        return result;
    }

}

