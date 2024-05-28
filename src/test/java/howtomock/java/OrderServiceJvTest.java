package howtomock.java;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceJvTest {
    @Mock
    private OrderRepositoryJv orderRepositoryJv;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void make_repository_to_return_order_entity() {
        OrderEntityJv orderEntityJv = orderRepositoryJv.getOrderEntityJv();
        assertNotNull(orderEntityJv);
    }
}