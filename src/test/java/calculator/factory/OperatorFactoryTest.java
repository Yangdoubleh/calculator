package calculator.factory;

import calculator.operator.impl.DevideOperator;
import calculator.operator.impl.MinusOperator;
import calculator.operator.impl.MultipleOperator;
import calculator.operator.impl.PlusOperator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

class OperatorFactoryTest {

    OperatorFactory operatorFactory = OperatorFactory.getInstance();
    String operator;

    @DisplayName("싱글톤 패턴 테스트")
    @Test
    void getInstance() {
        OperatorFactory newOperatorFactory = OperatorFactory.getInstance();

        assertEquals(operatorFactory, newOperatorFactory);
    }

    @DisplayName("싱글톤 멀티 쓰레드 테스트")
    @Test
    void multiGetInstance() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CountDownLatch latch = new CountDownLatch(2);
        AtomicReference<OperatorFactory> operatorFactory1 = new AtomicReference<>();
        AtomicReference<OperatorFactory> operatorFactory2 = new AtomicReference<>();
        executorService.execute(() -> {
            operatorFactory1.set(OperatorFactory.getInstance());
            latch.countDown();
        });
        executorService.execute(() -> {
            operatorFactory2.set(OperatorFactory.getInstance());
            latch.countDown();
        });
        latch.await();
        assertEquals(operatorFactory1.get(), operatorFactory2.get());
    }

    @DisplayName("나누기 operator 생성")
    @Test
    void createDevideOperator() {
        operator = "/";

        assertEquals(operatorFactory.createOperator(operator), DevideOperator.getInstance());
    }

    @DisplayName("곱하기 operator 생성")
    @Test
    void createMultipleOperator() {
        operator = "*";

        assertEquals(operatorFactory.createOperator(operator), MultipleOperator.getInstance());
    }

    @DisplayName("더하기 operator 생성")
    @Test
    void createPlusOperator() {
        operator = "+";

        assertEquals(operatorFactory.createOperator(operator), PlusOperator.getInstance());
    }

    @DisplayName("빼기 operator 생성")
    @Test
    void createMinusOperator() {
        operator = "-";

        assertEquals(operatorFactory.createOperator(operator), MinusOperator.getInstance());
    }
}