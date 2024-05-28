package howtomock.one;


import howtomock.java.OrderRepositoryJv;
import org.junit.jupiter.api.BeforeEach;

class OrderServiceJvTest {

    private OrderRepositoryJv orderRepositoryJv;


    @BeforeEach
    public void setup() {
        orderRepositoryJv = new OrderRepositoryJv();
    }
}