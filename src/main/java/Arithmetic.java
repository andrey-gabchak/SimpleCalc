import Operations.AllOperations;
import Operations.Operation;

import java.math.BigDecimal;
import java.util.List;
import java.util.Stack;


public class Arithmetic {
    private final List<Operation> operationsList = AllOperations.getAllOperations().getOperationsList();

    private Stack<BigDecimal> stackResult = new Stack<>();


    public BigDecimal calculation(String expression) {
        Parser parser = new Parser();
        Stack<String> stack = parser.parsing(expression);
        for (String s : stack) {
            try {
                stackResult.push(new BigDecimal(s));
            } catch (NumberFormatException e) {
                for (Operation operation : operationsList) {
                    if (s.equals(operation.getOperator())) {
                        stackResult.push(operation.getResult(stackResult.pop(), stackResult.pop()));
                    }
                }
            }
        }
        return stackResult.pop();
    }

}
