package Operations;

public interface Operation {

    double getResult(double num1, double num2);

    String getOperator();

    int getPriority();

    /*
    * Парсинг. Валидатор
    * Результат
    * Получить оператор (как знак). Нужно ли?
    * Получить приоритет оператора.
    * Ошибки
    * */
}
