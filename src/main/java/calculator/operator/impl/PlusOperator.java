package calculator.operator.impl;

import calculator.operator.Operator;

import java.math.BigDecimal;

public class PlusOperator implements Operator {
    @Override
    public BigDecimal operator(BigDecimal num1, BigDecimal num2) {
        return num1.add(num2);
    }
}
