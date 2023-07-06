package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = Calculator.getInstance();
    String input;
    Double result;

    @DisplayName("싱글톤 패턴 테스트")
    @Test
    void getInstance() {
        Calculator cal1 = Calculator.getInstance();
        Calculator cal2 = Calculator.getInstance();
        assertEquals(cal1, cal2);
    }

    @DisplayName("싱글톤 멀티쓰레드 테스트")
    @Test
    void multiGetInstance() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CountDownLatch latch = new CountDownLatch(2);
        AtomicReference<Calculator> calculator1 = new AtomicReference<>();
        AtomicReference<Calculator> calculator2 = new AtomicReference<>();
        executorService.execute(()->{
            calculator1.set(Calculator.getInstance());
            latch.countDown();
        });
        executorService.execute(()->{
            calculator2.set(Calculator.getInstance());
            latch.countDown();
        });
        latch.await();
        assertEquals(calculator1.get(), calculator2.get());
    }

    @DisplayName("계산기 테스트1")
    @Test
    void calculatorTest1() {
        input = "5+8";
        result = Double.valueOf(13);
        assertEquals(calculator.calResult(input).doubleValue(), result);
    }

    @DisplayName("계산기 테스트2")
    @Test
    void calculatorTest2() {
        input = "5.7-8.2";
        result = Double.valueOf(-2.5);
        assertEquals(calculator.calResult(input).doubleValue(), result);
    }

    @DisplayName("계산기 테스트3")
    @Test
    void calculatorTest3() {
        input = "5.7*-8.2";
        result = Double.valueOf(-46.74);
        assertEquals(calculator.calResult(input).doubleValue(), result);
    }

    @DisplayName("계산기 테스트4")
    @Test
    void calculatorTest4() {
        input = "3.8/1.6";
        result = Math.round(Double.valueOf(2.375 * 100)) / 100.0;
        assertEquals(calculator.calResult(input).doubleValue(), result);
    }

    @DisplayName("계산기 나눗셈 오류")
    @Test
    void calculatorException1() {
        input = "3.8/0";
        assertThrows(ArithmeticException.class, () -> calculator.calResult(input));
    }

    @DisplayName("계산 기호 오류")
    @Test
    void calculatorException2() {
        input = "3.8$5";
        assertThrows(NumberFormatException.class, () -> calculator.calResult(input));
    }
}