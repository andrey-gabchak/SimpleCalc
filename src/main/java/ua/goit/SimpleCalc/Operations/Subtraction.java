package ua.goit.SimpleCalc.Operations;

public class Subtraction implements BinaryOperation {
    @Override
    public double getResult(double num1, double num2) {
        return num2 - num1;
    }

    @Override
    public String getOperator() {
        return "-";
    }

    @Override
    public int getPriority() {
        return 1;
    }
}
