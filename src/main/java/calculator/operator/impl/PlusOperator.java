package calculator.operator.impl;

import calculator.operator.Operator;

import java.math.BigDecimal;

public class PlusOperator implements Operator {

    private PlusOperator() {
    }

    private static class PlusOperatorHolder {
        private static final PlusOperator instance = new PlusOperator();
    }

    public static PlusOperator getInstance() {

        return PlusOperatorHolder.instance;
    }

    @Override
    public BigDecimal operator(BigDecimal num1, BigDecimal num2) {
        return num1.add(num2);
    }
}
