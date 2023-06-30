package calculator.operator.impl;

import calculator.operator.Operator;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class DevideOperatorTest {

    @Test
    void getInstance() {
        Operator operator1 = DevideOperator.getInstance();
        Operator operator2 = DevideOperator.getInstance();
        assertEquals(operator1, operator2);
    }

    @Test
    void operator1() {
        Operator operator = DevideOperator.getInstance();
        BigDecimal num1 = BigDecimal.valueOf(10);
        BigDecimal num2 = BigDecimal.valueOf(5);
        BigDecimal result = BigDecimal.valueOf(2);
        assertEquals(operator.operator(num1, num2), result);
    }

    @Test
    void operator2() {
        Operator operator = DevideOperator.getInstance();
        BigDecimal num1 = BigDecimal.valueOf(10);
        BigDecimal num2 = BigDecimal.valueOf(0);
        assertThrows(ArithmeticException.class, () -> {
            operator.operator(num1, num2);
        });
    }
}