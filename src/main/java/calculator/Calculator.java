package calculator;

import calculator.operator.impl.PlusOperator;

public class Calculator {

    private static Calculator calculator = new Calculator();

    private Calculator() {
    }

    public static Calculator getInstance() {
        return calculator;
    }

    public void calResult(String cal) {
        try {

        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }
}
