package calculator;

public class Calculator {

    private static Calculator calculator = new Calculator();

    private Calculator() {
    }

    public static Calculator getInstance() {
        return calculator;
    }

    public void calResult(String cal) {
        System.out.println("계산 결과 : " + cal);
    }
}
