package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void getInstance() {
        Calculator cal1 = Calculator.getInstance();
        Calculator cal2 = Calculator.getInstance();
        assertEquals(cal1, cal2);
    }
}