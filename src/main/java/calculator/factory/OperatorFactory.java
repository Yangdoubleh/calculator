package calculator.factory;

import calculator.factory.constant.OperatorType;
import calculator.operator.Operator;
import calculator.operator.impl.DevideOperator;
import calculator.operator.impl.MinusOperator;
import calculator.operator.impl.MultipleOperator;
import calculator.operator.impl.PlusOperator;

import java.util.HashMap;
import java.util.Map;

import static calculator.factory.constant.OperatorType.*;

public class OperatorFactory {

    private static final Map<OperatorType, Operator> typeOperatorMap = new HashMap<>();
    private static OperatorFactory operatorFactory = new OperatorFactory();
    private OperatorFactory() {
        typeOperatorMap.put(PLUS, PlusOperator.getInstance());
        typeOperatorMap.put(MINUS, MinusOperator.getInstance());
        typeOperatorMap.put(MULTIPLE, MultipleOperator.getInstance());
        typeOperatorMap.put(DEVIDE, DevideOperator.getInstance());
    }

    public static OperatorFactory getInstance() {
        return operatorFactory;
    }



    public Operator createOperator(String operator) {
        try {
            OperatorType operatorType = OperatorType.getOperator(operator);
            return typeOperatorMap.get(operatorType);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("유효하지 않은 계산 기호 입니다.");
        }
    }
}
