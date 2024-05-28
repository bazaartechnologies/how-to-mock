package howtomock.one;


import howtomock.java.OrderRepositoryJv;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.never;

class OrderServiceJvTest {
    @Mock
    private OrderRepositoryJv orderRepositoryJv;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void test() {
        Assertions.assertTrue(true);
        verify(orderRepositoryJv, never()).getOrderEntityJv();
    }
}