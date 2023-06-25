import calculator.Calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            Calculator calculator = Calculator.getInstance();
            while (true) {
                System.out.println("계산식을 입력 해주세요. exit를 입력하면 시스템이 종료됩니다.");
                String input = br.readLine();
                if ("exit".equals(input)) {
                    break;
                }
                calculator.calResult(input);
            }
        } catch (IOException e) {
            System.out.println("오류 발생");
            e.printStackTrace();
        }
    }
}