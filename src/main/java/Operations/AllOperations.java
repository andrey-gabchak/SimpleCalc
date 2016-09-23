package Operations;

import java.util.ArrayList;
import java.util.List;

public class AllOperations {

    private static AllOperations allOperations;
    private ArrayList<BinaryOperation> binaryOperations = new ArrayList<>();
    private ArrayList<UnaryOperation> unaryOperations = new ArrayList<>();
    private String allOperationsLikeString;
    private String binaryOperationLikeString;
    private String unaryOperationLikeString;

    private AllOperations() {
    }

    public static AllOperations getAllOperations() {
        if (allOperations == null) {
            allOperations = new AllOperations();
            allOperations.init();
        }
        return allOperations;
    }


    /* Костыль.
    * TODO: Нужно создать экземпляры всех классов, которые наследуются от интерфейса BinaryOperation
    * */
    private void init() {
        binaryOperations.add(new Addition());
        binaryOperations.add(new Subtraction());
        binaryOperations.add(new Power());
        unaryOperations.add(new Sqrt());
    }

    public void addBinaryOperation(BinaryOperation operation) {
        binaryOperations.add(operation);
    }

    public void addUnaryOperation(UnaryOperation operation) {
        unaryOperations.add(operation);
    }

    public List<BinaryOperation> getBinaryOperations() {
        return binaryOperations;
    }

    public ArrayList<UnaryOperation> getUnaryOperations() {
        return unaryOperations;
    }

    public String getBinaryOperationLikeString() {
        return binaryOperationLikeString;
    }

    public String getUnaryOperationLikeString() {
        return unaryOperationLikeString;
    }

    private void operationsToString(ArrayList<BinaryOperation> binaryList, ArrayList<UnaryOperation> unaryList) {
        StringBuilder unary = new StringBuilder();
        StringBuilder binary = new StringBuilder();

        for (UnaryOperation unaryOperation : unaryList) {
            unary.append(unaryOperation.getOperator());
        }

        for (BinaryOperation operation : binaryList) {
            binary.append(operation.getOperator());
        }

        unaryOperationLikeString = unary.toString();
        binaryOperationLikeString = binary.toString();
        allOperationsLikeString = unaryOperationLikeString + binaryOperationLikeString;
    }

    public String getAllOperationsLikeString() {
        if (allOperationsLikeString == null) {
            AllOperations.getAllOperations().operationsToString(binaryOperations, unaryOperations);
        }
        return allOperationsLikeString;
    }
}
