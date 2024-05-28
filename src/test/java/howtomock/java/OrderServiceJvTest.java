package howtomock.java;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceJvTest {
    @Mock
    private OrderRepositoryJv orderRepositoryJv;

    private OrderServiceJv orderServiceJv;

    @BeforeEach
    void setup() {
        orderServiceJv = new OrderServiceJv(orderRepositoryJv);
    }
    @Test
    void task_3() {
        // stubbing
        when(orderRepositoryJv.getOrderEntityJv()).thenReturn(
                new OrderEntityJv(
                        "order", "orderNumber", 3
                )
        );

        // Action
        OrderEntityJv orderEntityJv = orderServiceJv.fetchOrderEntityJv();

        assertNotNull(orderEntityJv);
    }


    // Task 4
    @Test
    void test_4() {
        OrderEntityJv orderEntityJv = new OrderEntityJv("order", "orderNumber", 3);

        // Action
        orderServiceJv.saveSomething(orderEntityJv);

        verify(orderRepositoryJv).saveOrderEntityJv(any());
    }


    // Task 5
    @Test
    void test_5() {
        OrderEntityJv orderEntityJv = new OrderEntityJv("order", "orderNumber", 3);

        when(orderRepositoryJv.saveOrderEntityJv(any())).thenReturn(100);

        // Action
        Integer integer = orderServiceJv.saveSomething(orderEntityJv);

        Assertions.assertEquals(100, integer);
    }


    // Task 6
    @Test
    void test_6a() {
        OrderEntityJv orderEntityJv = new OrderEntityJv("order", "orderNumber", 3);

        when(orderRepositoryJv.saveOrderEntityJv(any())).thenReturn(100);

        // Action
        Integer integer = orderServiceJv.saveSomething(orderEntityJv);

        Assertions.assertEquals(100, integer);
        verify(orderRepositoryJv).saveOrderEntityJv(orderEntityJv);

    }

    @Test
    void test_6b() {
        OrderEntityJv orderEntityJv = new OrderEntityJv("order", "orderNumber", 3);

        when(orderRepositoryJv.saveOrderEntityJv(orderEntityJv)).thenReturn(100);

        // Action
        Integer integer = orderServiceJv.saveSomething(orderEntityJv);

        Assertions.assertEquals(100, integer);
    }

    @Test
    void test_6c() {
        OrderEntityJv orderEntityJv = new OrderEntityJv("order", "orderNumber", 3);

        // Action
        orderServiceJv.saveSomething(orderEntityJv);

        verify(orderRepositoryJv).saveOrderEntityJv(orderEntityJv);
    }


    @Test
    void test_7() {
        OrderEntityJv orderEntityJv = new OrderEntityJv("order", "orderNumber", 3);
        // Action
        orderServiceJv.saveSomethingThatChangesTheData(orderEntityJv);

        verify(orderRepositoryJv).saveOrderEntityJv(orderEntityJv);
    }

    @Test
    void test_7b() {
        OrderEntityJv orderEntityJv = new OrderEntityJv("order", "orderNumber", 3);
        // Action
        orderServiceJv.saveSomethingThatIsCreateNewInstanceWithSameData(orderEntityJv);

        verify(orderRepositoryJv).saveOrderEntityJv(orderEntityJv);
    }


    @Test
    void test_7c() {

    }
}