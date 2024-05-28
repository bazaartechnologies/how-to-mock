package howtomock.java;

public class OrderEntityJv {
    private String orderId;
    private String orderNumber;
    private Integer itemCount;

    public OrderEntityJv(String orderId, String orderNumber, Integer itemCount) {
        this.orderId = orderId;
        this.orderNumber = orderNumber;
        this.itemCount = itemCount;
    }
}
