package ua.goit.SimpleCalc;

import ua.goit.SimpleCalc.Operations.AllOperations;
import ua.goit.SimpleCalc.Operations.BinaryOperation;
import ua.goit.SimpleCalc.Operations.UnaryOperation;

import java.util.List;
import java.util.Stack;


public class Arithmetic {
    private final List<BinaryOperation> binaryOperations = AllOperations.getAllOperations().getBinaryOperations();
    private final List<UnaryOperation> unaryOperations = AllOperations.getAllOperations().getUnaryOperations();

    private Stack<Double> stackResult = new Stack<>();


    public Double calculation(Stack<String> stackPRN) {

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
