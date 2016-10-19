package ua.goit.SimpleCalc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class RunnerCalc {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputExpression = reader.readLine();

        Parser parser = new Parser();
        Stack<String> stackPRN = parser.parsing(inputExpression);

        Arithmetic arithmetic = new Arithmetic();
        double result = arithmetic.calculation(stackPRN);

        System.out.println(result);
    }
}
