package calculator.operator.impl;

import calculator.operator.Operator;

import java.math.BigDecimal;

public class DevideOperator implements Operator {

    private DevideOperator() {
    }

    private static class DevideOperatorHolder {
        private static final DevideOperator instance = new DevideOperator();
    }

    public static DevideOperator getInstance() {
        return DevideOperatorHolder.instance;
    }

    @Override
    public BigDecimal operator(BigDecimal num1, BigDecimal num2) throws ArithmeticException {
        return num1.divide(num2, 2, BigDecimal.ROUND_HALF_UP);
    }
}
