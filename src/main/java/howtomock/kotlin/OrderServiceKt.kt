package howtomock.kotlin

import howtomock.java.OrderEntityJv
import kotlin.random.Random.Default.nextInt

class OrderServiceKt(private val orderRepositoryKt: OrderRepositoryKt) {
    fun fetchOrderEntityKt(): OrderEntityKt {
        return orderRepositoryKt.getOrderEntityKt()
    }

    fun saveSomething(orderEntityKt: OrderEntityKt): Int {
        return orderRepositoryKt.saveOrderEntityKt(orderEntityKt)
    }

    fun saveSomethingThatChangesTheData(orderEntityKt: OrderEntityKt): Int {
        orderEntityKt.itemCount = 100
        return orderRepositoryKt.saveOrderEntityKt(orderEntityKt)
    }

    fun saveSomethingThatIsCreateNewInstanceWithSameData(orderEntityKt: OrderEntityKt): Int {
        return orderRepositoryKt.saveOrderEntityKt(
            OrderEntityKt(
                orderEntityKt.orderId, orderEntityKt.orderNumber, orderEntityKt.itemCount
            )
        )
    }

    fun saveSomethingWithNewInstance(orderId: String, orderNumber: String): Int {
        val itemCount = nextInt(0, 100)
        val orderEntityKt = OrderEntityKt(
            orderId, orderNumber, itemCount
        )
        return orderRepositoryKt.saveOrderEntityKt(
            orderEntityKt
        )
    }


    fun saveSomethingWithNewInstanceOfJava(orderId: String, orderNumber: String): Int {
        val itemCount = nextInt(0, 100)
        val orderEntityJv = OrderEntityJv(
            orderId, orderNumber, itemCount
        )
        return orderRepositoryKt.saveOrderEntityJv(
            orderEntityJv,
            listOf("hello")
        )
    }

    fun saveSomethingWithNewInstanceOfJavaWhichWeCanPredict(orderId: String, orderNumber: String, itemCount: Int): Int {
        val orderEntityJv = OrderEntityJv(
            orderId, orderNumber, itemCount
        )
        return orderRepositoryKt.saveOrderEntityJv(
            orderEntityJv,
            listOf("hello")
        )
    }

    fun saveSomethingIfOrderIdIsNotEmpty(orderId: String, orderNumber: String, itemCount: Int): Int {
        if (orderId.isEmpty()) return -1;

        val orderEntityKt = OrderEntityKt(
            orderId, orderNumber, itemCount
        )
        return orderRepositoryKt.saveOrderEntityKt(
            orderEntityKt
        )
    }
}