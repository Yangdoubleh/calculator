package calculator.operator.impl;

import calculator.operator.Operator;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PlusOperatorTest {

    Operator operator = PlusOperator.getInstance();

    @Test
    void getInstance() {
        Operator newOperator = PlusOperator.getInstance();

        assertEquals(operator, newOperator);
    }

    @Test
    void operator() {
        BigDecimal num1 = BigDecimal.valueOf(10);
        BigDecimal num2 = BigDecimal.valueOf(5);
        BigDecimal result = BigDecimal.valueOf(15);

        assertEquals(operator.operator(num1, num2), result);
    }
}