package calculator.factory;

import calculator.factory.constant.OperatorType;
import calculator.operator.Operator;

public class OperatorFactory {

    public Operator createOperator(String operator) {
        OperatorType operatorType = OperatorType.getOperator(operator);
        
    }
}
