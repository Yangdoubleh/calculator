package calculator;

import calculator.factory.OperatorFactory;
import calculator.operator.Operator;
import calculator.operator.impl.PlusOperator;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Calculator {

    private static Calculator calculator = new Calculator();
    private final OperatorFactory operatorFactory = OperatorFactory.getInstance();

    private Calculator() {
    }

    public static Calculator getInstance() {
        return calculator;
    }

    public BigDecimal calResult(String cal) {
        try {
            for (byte b : cal.getBytes()) {

            }
            Operator operator = operatorFactory.createOperator("");
            return operator.operator();
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }
}
