package Operations;

import java.math.BigDecimal;

public class Addition implements Operation {

    @Override
    public BigDecimal getResult(BigDecimal num1, BigDecimal num2) {
        return num1.add(num2);
    }

    @Override
    public String getOperator() {
        return "+";
    }

    @Override
    public int getPriority() {
        return 1;
    }
}
