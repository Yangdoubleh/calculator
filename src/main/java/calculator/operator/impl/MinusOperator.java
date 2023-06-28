package calculator.operator.impl;

import calculator.operator.Operator;

import java.math.BigDecimal;

public class MinusOperator implements Operator {
    private static MinusOperator minusOperator = new MinusOperator();

    private MinusOperator() {
    }

    public static MinusOperator getInstance() {
        return minusOperator;
    }

    @Override
    public BigDecimal operator(BigDecimal num1, BigDecimal num2) {
        return num1.subtract(num2);
    }
}
