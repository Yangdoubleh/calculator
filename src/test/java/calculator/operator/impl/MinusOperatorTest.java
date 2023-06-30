package calculator.operator.impl;

import calculator.operator.Operator;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class MinusOperatorTest {

    @Test
    void getInstance() {
        Operator operator1 = MinusOperator.getInstance();
        Operator operator2 = MinusOperator.getInstance();

        assertEquals(operator1, operator2);
    }

    @Test
    void operator() {
        Operator operator = MinusOperator.getInstance();
        BigDecimal num1 = BigDecimal.valueOf(10);
        BigDecimal num2 = BigDecimal.valueOf(5);
        BigDecimal result = BigDecimal.valueOf(5);

        assertEquals(operator.operator(num1, num2), result);
    }
}