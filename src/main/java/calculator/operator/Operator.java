package calculator.operator;

import java.math.BigDecimal;

public interface Operator {
    BigDecimal operator(BigDecimal num1, BigDecimal num2) throws Exception;
}
