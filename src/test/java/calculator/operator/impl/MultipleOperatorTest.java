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

class MultipleOperatorTest {
    private final Operator operator = MultipleOperator.getInstance();

    @DisplayName("싱글톤 패턴 테스트")
    @Test
    void getInstance() {
        Operator newOperator = MultipleOperator.getInstance();

        assertEquals(operator, newOperator);
    }

    @DisplayName("멀티쓰레드 싱글톤 테스트")
    @Test
    void multiGetInstance() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CountDownLatch latch = new CountDownLatch(2);

        AtomicReference<Operator> operator1 = new AtomicReference<>();
        AtomicReference<Operator> operator2 = new AtomicReference<>();

        executorService.execute(() -> {
            operator1.set(MultipleOperator.getInstance());
            latch.countDown();
        });
        executorService.execute(() -> {
            operator2.set(MultipleOperator.getInstance());
            latch.countDown();
        });
        latch.await();
        assertEquals(operator1.get(), operator2.get());
    }

    @DisplayName("곱하기 연산 테스트")
    @Test
    void multiOperator() {
        BigDecimal num1 = BigDecimal.valueOf(10);
        BigDecimal num2 = BigDecimal.valueOf(5);
        BigDecimal result = BigDecimal.valueOf(50);

        assertEquals(operator.operator(num1, num2), result);
    }
}