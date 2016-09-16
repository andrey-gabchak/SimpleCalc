package Operations;

import java.math.BigDecimal;

public class Substraction implements Operation {
    @Override
    public BigDecimal getResult(BigDecimal num1, BigDecimal num2) {
        return num2.subtract(num1);
    }

    @Override
    public String getOperator() {
        return "-";
    }

    @Override
    public int getPriority() {
        return 1;
    }
}
