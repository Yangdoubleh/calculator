package calculator.operator.impl;

import calculator.operator.Operator;

import java.math.BigDecimal;

public class PlusOperator implements Operator {
    private static PlusOperator plusOperator = new PlusOperator();

    private PlusOperator() {
    }

    public static PlusOperator getInstance() {
        return plusOperator;
    }

    @Override
    public BigDecimal operator(BigDecimal num1, BigDecimal num2) {
        return num1.add(num2);
    }
}
