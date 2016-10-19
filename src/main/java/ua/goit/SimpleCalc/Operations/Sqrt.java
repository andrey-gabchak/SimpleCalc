package ua.goit.SimpleCalc.Operations;

public class Sqrt implements UnaryOperation {
    @Override
    public double getResult(double value) {
        return Math.sqrt(value);
    }

    @Override
    public String getOperator() {
        return "s";
    }

    @Override
    public int getPriority() {
        return 3;
    }
}
