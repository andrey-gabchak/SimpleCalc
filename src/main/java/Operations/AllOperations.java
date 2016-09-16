package Operations;

import java.util.ArrayList;
import java.util.List;

public class AllOperations {

    private static AllOperations allOperations;
    private ArrayList<Operation> operationsList = new ArrayList<>();
    private String operationsLikeString;

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
    * TODO: Нужно создать экземпляры всех классов, которые наследуются от интерфейса Operation
    * */
    private void init() {
        operationsList.add(new Addition());
        operationsList.add(new Substraction());
    }

    public void addOperation(Operation operation) {
        operationsList.add(operation);
    }

    public List<Operation> getOperationsList() {
        return operationsList;
    }


    //TODO: Проверить будет ли ошибка если list.size() == 0
    private String operationsToString(ArrayList<Operation> list) {
        StringBuilder operationsLikeString = new StringBuilder();
        for (Operation operation : list) {
            operationsLikeString.append(operation.getOperator());
        }
        return operationsLikeString.toString();
    }

    public String getOperationsLikeString() {
        if (operationsLikeString == null) {
            operationsLikeString = AllOperations.getAllOperations().operationsToString(operationsList);
        }
        return operationsLikeString;
    }
}
