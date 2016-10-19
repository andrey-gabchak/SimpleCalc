package ua.goit.SimpleCalc.Operations;

import static java.lang.Math.pow;

public class Power implements BinaryOperation {
    @Override
    public double getResult(double num1, double num2) {
        return pow(num2, num1);
    }

    @Override
    public String getOperator() {
        return "^";
    }

    @Override
    public int getPriority() {
        return 3;
    }
}
