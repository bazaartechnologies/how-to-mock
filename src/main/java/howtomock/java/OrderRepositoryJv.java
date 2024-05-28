package howtomock.java;

import java.net.NetworkInterface;

public class OrderRepositoryJv {

    private NetworkInterface networkInterface;

    public OrderRepositoryJv(NetworkInterface networkInterface) {
        this.networkInterface = networkInterface;
    }


    public OrderEntityJv getOrderEntityJv() {
        return new OrderEntityJv(
                "order-id-x","order-number-x", 3
        );
    }

    public Integer saveOrderEntityJv(OrderEntityJv orderEntityJv)
    {
        return 1000;
    }
}
