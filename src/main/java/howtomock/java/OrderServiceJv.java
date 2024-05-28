package howtomock.java;

public class OrderServiceJv {
    private OrderRepositoryJv orderRepositoryJv;

    public OrderServiceJv(OrderRepositoryJv orderRepositoryJv) {
        this.orderRepositoryJv = orderRepositoryJv;
    }
}
