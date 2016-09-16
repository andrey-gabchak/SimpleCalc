import Operations.AllOperations;

public class Errors {
    private final String OPERATORS = AllOperations.getAllOperations().getOperationsLikeString();

    public void checkErrors(String inputExpression) {
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
            if (isOperationSign(inputToCharArray[i]) && isOperationSign(inputToCharArray[i + 1])
                    && (i < inputToCharArray.length - 1)) {
                throw new RuntimeException("Два знака подряд!");
            }
        }

        for (char character : inputToCharArray) {
            if (!isDigit(character) && !isOperationSign(character)) {
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

        if (countBrackets != 0) {
            return false;
        }
        return true;
    }

    /**
     * не является ли последний симвом в выражении арифметической операцией
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
        if (String.valueOf(c).equals(")") || String.valueOf(c).equals("(")) {
            return true;
        }
        return false;
    }
}
