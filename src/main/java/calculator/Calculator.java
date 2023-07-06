package calculator;

import calculator.factory.OperatorFactory;
import calculator.operator.Operator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Calculator {

    private final Map<Byte, String> OPERATORMAP = new HashMap<>();
    private static class CalculatorHolder {
        private static final Calculator instance = new Calculator();
    }
    private final OperatorFactory operatorFactory = OperatorFactory.getInstance();

    private Calculator() {
        OPERATORMAP.put("+".getBytes()[0], "+");
        OPERATORMAP.put("-".getBytes()[0], "-");
        OPERATORMAP.put("*".getBytes()[0], "*");
        OPERATORMAP.put("/".getBytes()[0], "/");
        OPERATORMAP.put(" ".getBytes()[0], "");
    }

    public static Calculator getInstance() {
        return CalculatorHolder.instance;
    }

    public BigDecimal calResult(String cal) {
        BigDecimal result = BigDecimal.ZERO;
        try {
            cal = cal.trim();
            String operate = this.getOperate(cal);
            int operateIndex = cal.indexOf(operate);
            BigDecimal num1 = BigDecimal.valueOf(Double.parseDouble(cal.substring(0, operateIndex)));
            BigDecimal num2 = BigDecimal.valueOf(Double.parseDouble(cal.substring(operateIndex + 1, cal.length())));
            Operator operator = operatorFactory.createOperator(operate);
            result = operator.operator(num1, num2);
        } catch (NullPointerException e) {
            System.out.println("유효하지 않은 계산 기호 입니다.");
        } catch (RuntimeException e) {
            System.out.println(e);
        }
        return result;
    }

    private String getOperate(String cal) {
        for (Byte calByte : cal.getBytes()) {
            Optional<Map.Entry<Byte, String>> optionalByteStringEntry = OPERATORMAP.entrySet().stream()
                    .filter(operator -> operator.getKey().equals(calByte))
                    .findFirst();
            if (optionalByteStringEntry.isPresent()) {
                return optionalByteStringEntry.get().getValue();
            }
        }
        return "";
    }
}
