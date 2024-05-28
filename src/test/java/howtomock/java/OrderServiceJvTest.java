package howtomock.java;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceJvTest {
    @Mock
    private OrderRepositoryJv orderRepositoryJv;

    @Test
    void make_repository_to_return_order_entity() {
        // stubbing
        when(orderRepositoryJv.getOrderEntityJv()).thenReturn(
                new OrderEntityJv(
                        "order", "orderNumber", 3
                )
        );

        OrderEntityJv orderEntityJv = orderRepositoryJv.getOrderEntityJv();
        assertNotNull(orderEntityJv);
    }
}