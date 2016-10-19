package ua.goit.SimpleCalc.Operations;

public interface UnaryOperation {


    double getResult(double value);

    String getOperator(); //Type String because I need compare with element of Stack<String>

    int getPriority();
}
