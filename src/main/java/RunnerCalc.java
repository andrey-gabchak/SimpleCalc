import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunnerCalc {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputExpression = reader.readLine();
        Arithmetic arithmetic = new Arithmetic();

        double result = arithmetic.calculation(inputExpression);
        System.out.println(result);
    }
}
