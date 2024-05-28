package howtomock.java;

import java.util.Objects;

public class OrderEntityJv {
    private String orderId;
    private String orderNumber;
    private Integer itemCount;

    public OrderEntityJv(String orderId, String orderNumber, Integer itemCount) {
        this.orderId = orderId;
        this.orderNumber = orderNumber;
        this.itemCount = itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    @Override
    public boolean equals(Object obj) {
        OrderEntityJv obj1 = (OrderEntityJv) obj;
        return (Objects.equals(obj1.itemCount, this.itemCount)) && (obj1.orderId.equals(this.orderId)) && (obj1.orderNumber.equals(this.orderNumber));
    }
}
