package Operations;

import java.math.BigDecimal;

public interface Operation {

    BigDecimal getResult(BigDecimal num1, BigDecimal num2);

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
