package ua.goit.SimpleCalc;

import ua.goit.SimpleCalc.Operations.AllOperations;

class Errors {
    private final String OPERATORS = AllOperations.getAllOperations().getAllOperationsLikeString();
    private final String BINARYOPERATORS = AllOperations.getAllOperations().getBinaryOperationLikeString();
    private final String UNARYOPERATORS = AllOperations.getAllOperations().getUnaryOperationLikeString();

    protected void checkErrors(String inputExpression) {
        char[] inputToCharArray = inputExpression.toCharArray();

        if (!isCorrectCountBrackets(inputToCharArray)) {
            throw new RuntimeException("Не хватает скобок!");
        }
        if (checkLastSymbol(inputToCharArray)) {
            throw new RuntimeException("В конце не может быть оператор!");
        }

        for (int i = 0; i < inputToCharArray.length; i++) {
            if (!isDigit(inputToCharArray[i]) && !isOperationSign(inputToCharArray[i]) && !isBracket(inputToCharArray[i])) {
                throw new RuntimeException("Не корректный ввод!");
            }
            if (isUnaryOperator(inputToCharArray[i]) && isUnaryOperator(inputToCharArray[i + 1])
                    && (i < inputToCharArray.length - 1)) {
                throw new RuntimeException("Два унарных оператора подряд!");
            }
            if (isBinaryOperator(inputToCharArray[i]) && isBinaryOperator(inputToCharArray[i + 1])
                    && (i < inputToCharArray.length - 1)) {
                throw new RuntimeException("Два бинарных оператора подряд!");
            }
        }
    }

    /**
     * равно ли число открыывающих и закрывающих кавычек
     */
    private boolean isCorrectCountBrackets(char[] charArray) {
        int countBrackets = 0;

        for (char c : charArray) {
            if (String.valueOf(c).equals("(")) {
                countBrackets += 1;
            }

            if (String.valueOf(c).equals(")")) {
                countBrackets -= 1;
            }
        }

        return countBrackets == 0;
    }

    /**
     * if last symbol is a operation
     */
    private boolean checkLastSymbol(char[] charArray) {
        return isOperationSign(charArray[charArray.length - 1]);
    }

    /**
     * Is it a operation?
     */
    private boolean isOperationSign(final char c) {
        return OPERATORS.indexOf(c) != -1;
    }


    /**
     * Is it a number?
     */
    private boolean isDigit(final char c) {
        return "0123456789.".indexOf(c) != -1;
    }

    /**
     * Is it a bracket?
     * */
    private boolean isBracket(final char c) {
        return String.valueOf(c).equals(")") || String.valueOf(c).equals("(");
    }

    private boolean isUnaryOperator(char c) {
        return UNARYOPERATORS.indexOf(c) != -1;
    }

    private boolean isBinaryOperator(char c) {
        return BINARYOPERATORS.indexOf(c) != -1;
    }
}
