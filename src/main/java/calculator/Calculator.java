package calculator;

import calculator.factory.OperatorFactory;
import calculator.operator.Operator;

import java.math.BigDecimal;

public class Calculator {

    private static Calculator calculator = new Calculator();
    private final OperatorFactory operatorFactory = OperatorFactory.getInstance();

    private Calculator() {
    }

    public static Calculator getInstance() {
        return calculator;
    }

    public BigDecimal calResult(String cal) {
        BigDecimal result = BigDecimal.ZERO;
        try {
            BigDecimal num1 = BigDecimal.valueOf(5);
            BigDecimal num2 = BigDecimal.valueOf(10);
            Operator operator = operatorFactory.createOperator("+");
            result = operator.operator(num1, num2);
        } catch (NullPointerException e) {
            System.out.println("유효하지 않은 계산 기호 입니다.");
        } catch (RuntimeException e) {
            System.out.println(e);
        }
        return result;
    }
}
