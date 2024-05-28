package howtomock.java;

import kotlin.random.Random;

public class OrderServiceJv {
    private OrderRepositoryJv orderRepositoryJv;

    public OrderServiceJv(OrderRepositoryJv orderRepositoryJv) {
        this.orderRepositoryJv = orderRepositoryJv;
    }

    public OrderEntityJv fetchOrderEntityJv() {
        return orderRepositoryJv.getOrderEntityJv();
    }

    public Integer saveSomething(OrderEntityJv orderEntityJv) {
        return orderRepositoryJv.saveOrderEntityJv(orderEntityJv);
    }

    public Integer saveSomethingThatChangesTheData(OrderEntityJv orderEntityJv) {
        orderEntityJv.setItemCount(100);
        return orderRepositoryJv.saveOrderEntityJv(orderEntityJv);
    }

    public Integer saveSomethingThatIsCreateNewInstanceWithSameData(OrderEntityJv orderEntityJv) {
        return orderRepositoryJv.saveOrderEntityJv(new OrderEntityJv(
                orderEntityJv.getOrderId(), orderEntityJv.getOrderNumber(), orderEntityJv.getItemCount()
        ));
    }

    public Integer saveSomethingWithNewInstance(String orderId, String orderNumber) {

        Integer itemCount = Random.Default.nextInt(0, 100);

        return orderRepositoryJv.saveOrderEntityJv(new OrderEntityJv(
                orderId, orderNumber, itemCount
        ));
    }
}
