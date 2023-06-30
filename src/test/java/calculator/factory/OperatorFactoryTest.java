package calculator.factory;

import calculator.operator.Operator;
import calculator.operator.impl.DevideOperator;
import calculator.operator.impl.MinusOperator;
import calculator.operator.impl.MultipleOperator;
import calculator.operator.impl.PlusOperator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatorFactoryTest {

    OperatorFactory operatorFactory = OperatorFactory.getInstance();
    String operator;

    @Test
    void getInstance() {
        OperatorFactory newOperatorFactory = OperatorFactory.getInstance();

        assertEquals(operatorFactory, newOperatorFactory);
    }

    @Test
    void createOperator1() {
        operator = "/";

        assertEquals(operatorFactory.createOperator(operator), DevideOperator.getInstance());
    }

    @Test
    void createOperator2() {
        operator = "*";

        assertEquals(operatorFactory.createOperator(operator), MultipleOperator.getInstance());
    }

    @Test
    void createOperator3() {
        operator = "+";

        assertEquals(operatorFactory.createOperator(operator), PlusOperator.getInstance());
    }

    @Test
    void createOperator4() {
        operator = "-";

        assertEquals(operatorFactory.createOperator(operator), MinusOperator.getInstance());
    }
}