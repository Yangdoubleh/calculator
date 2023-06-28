package calculator.factory.constant;

import calculator.operator.impl.PlusOperator;

import java.util.Arrays;

public enum OperatorType {
    PLUS("+"),
    MINUS("-"),
    MULTIPLE("*"),
    DEVIDE("/"),
    ETC("");


    private String operator;

    private OperatorType(String operator) {
        this.operator = operator;
    }
    private String getOperator() {
        return operator;
    }

    public static OperatorType getOperator(String type) {
        if(type == null || "".equals(type)) {
            return ETC;
        }

        return Arrays.stream(values())
                .filter(operator -> type.equals(operator.getOperator()))
                .findFirst()
                .orElse(ETC);
    }
}
