import Operations.AllOperations;
import Operations.BinaryOperation;
import Operations.UnaryOperation;

import java.util.List;
import java.util.Stack;


class Arithmetic {
    private final List<BinaryOperation> binaryOperations = AllOperations.getAllOperations().getBinaryOperations();
    private final List<UnaryOperation> unaryOperations = AllOperations.getAllOperations().getUnaryOperations();

    private Stack<Double> stackResult = new Stack<>();


    protected Double calculation(String expression) {
        Parser parser = new Parser();
        Stack<String> stackPRN = parser.parsing(expression);

        for (String s : stackPRN) {
            try {
                stackResult.push(new Double(s));
            } catch (NumberFormatException e) {
                for (BinaryOperation binaryOperation : binaryOperations) {
                    if (s.equals(binaryOperation.getOperator())) {
                        stackResult.push(binaryOperation.getResult(stackResult.pop(), stackResult.pop()));
                    }
                }
                for (UnaryOperation unaryOperation : unaryOperations) {
                    if (s.equals(unaryOperation.getOperator())) {
                        stackResult.push(unaryOperation.getResult(stackResult.pop()));
                    }
                }
            }
        }
        return stackResult.pop();
    }

}
