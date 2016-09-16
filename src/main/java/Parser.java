import Operations.AllOperations;
import Operations.Operation;
import java.math.BigDecimal;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

class Parser {
    private List<Operation> operationsList = AllOperations.getAllOperations().getOperationsList();
    private final String OPERATORS = AllOperations.getAllOperations().getOperationsLikeString();
    private Stack<String> stackOperations = new Stack<>();
    private Stack<String> stackRPN = new Stack<>();

    protected Stack<String> parsing(String inputExpression) {
        //Проверка на ошибки
        Errors errors = new Errors();
        errors.checkErrors(inputExpression);

        stackOperations.clear();
        stackRPN.clear();

        inputExpression = replace(inputExpression);

        StringTokenizer expressionTokenizer = new StringTokenizer(inputExpression, OPERATORS + "()", true);

        while (expressionTokenizer.hasMoreTokens()) {
            String token = expressionTokenizer.nextToken();
            if (isNumber(token)) {
                stackRPN.push(token);
            } else if (token.equals("(")) {
                stackOperations.push(token);
            } else if (token.equals(")")) {
                while (!stackOperations.peek().equals("(")) {
                    stackRPN.push(stackOperations.pop());
                }
                stackOperations.pop();
            } else if (isOperator(token)) {
                while (!stackOperations.empty()
                        && getPrecedence(token) <= getPrecedence(stackOperations
                        .lastElement())) {
                    stackRPN.push(stackOperations.pop());
                }
                stackOperations.push(token);
            }
        }
        while (!stackOperations.empty()) {
            stackRPN.push(stackOperations.pop());
        }

        return stackRPN;
    }

    private boolean isNumber(String token) {
        try {
            new BigDecimal(token);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean isOperator(String token) {
        return OPERATORS.contains(token);
    }

    private int getPrecedence(String token) {
        for (Operation operation : operationsList) {
            if (token.equals(operation.getOperator())) {
                return operation.getPriority();
            }
        }
        return 0;
    }

    //Type float parsing like double
    private String replace(String inputExpression) {
        inputExpression = inputExpression.replace(" ", "").replace("(-", "(0-").replace("f", "");
        if (inputExpression.charAt(0) == '-') {
            inputExpression = "0" + inputExpression;
        }
        return inputExpression;
    }
}
