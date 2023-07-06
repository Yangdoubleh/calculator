package calculator.operator.impl;

import calculator.operator.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

class PlusOperatorTest {

    Operator operator = PlusOperator.getInstance();

    @DisplayName("싱글톤 패턴 테스트")
    @Test
    void getInstance() {
        Operator newOperator = PlusOperator.getInstance();

        assertEquals(operator, newOperator);
    }

    @DisplayName("멀티쓰레드 싱글톤 패턴 테스트")
    @Test
    void multiGetInstance() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CountDownLatch latch = new CountDownLatch(2);

        AtomicReference<Operator> operator1 = new AtomicReference<>();
        AtomicReference<Operator> operator2 = new AtomicReference<>();
        executorService.execute(() -> {
            operator1.set(PlusOperator.getInstance());
            latch.countDown();
        });
        executorService.execute(() -> {
            operator2.set(PlusOperator.getInstance());
            latch.countDown();
        });
        latch.await();
        assertEquals(operator1.get(), operator2.get());
    }

    @DisplayName("더하기 연산 테스트")
    @Test
    void plusOperator() {
        BigDecimal num1 = BigDecimal.valueOf(10);
        BigDecimal num2 = BigDecimal.valueOf(5);
        BigDecimal result = BigDecimal.valueOf(15);

        assertEquals(operator.operator(num1, num2), result);
    }
}