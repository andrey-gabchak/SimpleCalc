import Operations.AllOperations;
import Operations.BinaryOperation;
import Operations.UnaryOperation;

import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

class Parser {
    private List<BinaryOperation> binaryOperations = AllOperations.getAllOperations().getBinaryOperations();
    private List<UnaryOperation> unaryOperations = AllOperations.getAllOperations().getUnaryOperations();
    private final String OPERATORS = AllOperations.getAllOperations().getAllOperationsLikeString();
    private Stack<String> stackOperations = new Stack<>();
    private Stack<String> stackRPN = new Stack<>();

    protected Stack<String> parsing(String inputExpression) {

        inputExpression = replace(inputExpression);

        Errors errors = new Errors();
        errors.checkErrors(inputExpression);

        stackOperations.clear();
        stackRPN.clear();


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
            new Double(token);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean isOperator(String token) {
        return OPERATORS.contains(token);
    }

    private int getPrecedence(String token) {
        for (BinaryOperation operation : binaryOperations) {
            if (token.equals(operation.getOperator())) {
                return operation.getPriority();
            }
        }
        for (UnaryOperation unaryOperation : unaryOperations) {
            if (token.equals(unaryOperation.getOperator())) {
                return unaryOperation.getPriority();
            }
        }
        return 0;
    }

    //Type float parsing like double
    private String replace(String inputExpression) {
        inputExpression = inputExpression.replace(" ", "").replace("(-", "(0-").replace("f", "").replace("sqrt", "s");
        if (inputExpression.charAt(0) == '-') {
            inputExpression = "0" + inputExpression;
        }
        return inputExpression;
    }
}
