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

class MinusOperatorTest {

    @DisplayName("싱글톤 패턴 테스트")
    @Test
    void getInstance() {
        Operator operator1 = MinusOperator.getInstance();
        Operator operator2 = MinusOperator.getInstance();

        assertEquals(operator1, operator2);
    }

    @DisplayName("멀티쓰레드 싱글톤 패턴 테스트")
    @Test
    void multiGetInstance() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CountDownLatch latch = new CountDownLatch(2);

        AtomicReference<Operator> operator1 = new AtomicReference<Operator>();
        AtomicReference<Operator> operator2 = new AtomicReference<Operator>();

        executorService.execute(() ->{
            operator1.set(MinusOperator.getInstance());
            latch.countDown();
        });
        executorService.execute(() ->{
            operator2.set(MinusOperator.getInstance());
            latch.countDown();
        });
        latch.await();
        assertEquals(operator1.get(), operator2.get());
    }

    @DisplayName("빼기 계산 테스트")
    @Test
    void minusOperator() {
        Operator operator = MinusOperator.getInstance();
        BigDecimal num1 = BigDecimal.valueOf(10);
        BigDecimal num2 = BigDecimal.valueOf(5);
        BigDecimal result = BigDecimal.valueOf(5);

        assertEquals(operator.operator(num1, num2), result);
    }
}