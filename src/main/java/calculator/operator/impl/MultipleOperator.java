package calculator.operator.impl;

import calculator.operator.Operator;

import java.math.BigDecimal;

public class MultipleOperator implements Operator {
    private static MultipleOperator multipleOperator = new MultipleOperator();

    private MultipleOperator() {
    }

    public static MultipleOperator getInstance() {
        return multipleOperator;
    }

    @Override
    public BigDecimal operator(BigDecimal num1, BigDecimal num2) {
        return num1.multiply(num2);
    }
}
