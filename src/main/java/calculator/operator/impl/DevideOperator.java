package calculator.operator.impl;

import calculator.operator.Operator;

import java.math.BigDecimal;

public class DevideOperator implements Operator {
    private static DevideOperator devideOperator = new DevideOperator();

    private DevideOperator() {
    }

    public static DevideOperator getInstance() { return devideOperator; }

    @Override
    public BigDecimal operator(BigDecimal num1, BigDecimal num2) throws ArithmeticException {
        return num1.divide(num2, 2, BigDecimal.ROUND_HALF_UP);
    }
}
