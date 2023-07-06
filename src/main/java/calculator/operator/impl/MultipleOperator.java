package calculator.operator.impl;

import calculator.operator.Operator;

import java.math.BigDecimal;

public class MultipleOperator implements Operator {
    private MultipleOperator() {
    }

    private static class  MultipleOperatorHolder {
        private static final MultipleOperator instance = new MultipleOperator();
    }

    public static MultipleOperator getInstance() {
        return MultipleOperatorHolder.instance;
    }

    @Override
    public BigDecimal operator(BigDecimal num1, BigDecimal num2) {
        return num1.multiply(num2);
    }
}
