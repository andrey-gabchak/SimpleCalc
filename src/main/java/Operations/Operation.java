package Operations;

public interface Operation {

    double getResult(double num1, double num2);

    String getOperator(); //Type String because I need compare with element of Stack<String>

    int getPriority();

}
