package calculator.operator.impl;

import calculator.operator.Operator;

import java.math.BigDecimal;

public class MinusOperator implements Operator {

    private MinusOperator() {
    }

    private static class MinusOperatorHolder {
        private static final MinusOperator instance = new MinusOperator();
    }

    public static MinusOperator getInstance() {
        return MinusOperatorHolder.instance;
    }

    @Override
    public BigDecimal operator(BigDecimal num1, BigDecimal num2) {
        return num1.subtract(num2);
    }
}
