package howtomock.kotlin

import howtomock.java.OrderEntityJv
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentCaptor
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.*

@ExtendWith(MockitoExtension::class)
internal class OrderServiceKtTest {
    @Mock
    private lateinit var orderRepositoryKt: OrderRepositoryKt
    private lateinit var orderServiceKt: OrderServiceKt

    @BeforeEach
    fun setup() {
        orderServiceKt = OrderServiceKt(orderRepositoryKt)
    }


    // When to use any()
    @Test
    fun whenToUseAny() {
        orderServiceKt.saveSomethingIfOrderIdIsNotEmpty("")

        verify(orderRepositoryKt, never()).saveOrderEntityKt(any())
    }

    // Task 6

    @Test
    fun test_6() {
        val orderEntityKt = OrderEntityKt("order", "orderNumber", 3)

        // Action
        orderServiceKt.saveSomething(orderEntityKt)
        Mockito.verify(orderRepositoryKt).saveOrderEntityKt(orderEntityKt)
    }

    @Test
    fun test_7a() {
        val orderEntityKt = OrderEntityKt("order", "orderNumber", 3)
        // Action
        orderServiceKt.saveSomethingThatChangesTheData(orderEntityKt)
        Mockito.verify(orderRepositoryKt).saveOrderEntityKt(orderEntityKt)
    }

    @Test
    fun test_7b() {
        val orderEntityKt = OrderEntityKt("order", "orderNumber", 3)
        // Action
        orderServiceKt.saveSomethingThatIsCreateNewInstanceWithSameData(orderEntityKt)
        Mockito.verify(orderRepositoryKt).saveOrderEntityKt(orderEntityKt)
    }


    /**
     * INTEOPERABILITY
     */

    @Test
    fun test_8a() {
        // Action
        orderServiceKt.saveSomethingWithNewInstance("order-id", "order-number")

        val orderCaptor: ArgumentCaptor<OrderEntityKt> = ArgumentCaptor.forClass(OrderEntityKt::class.java)

        Mockito.verify(orderRepositoryKt).saveOrderEntityKt(
            com.nhaarman.mockitokotlin2.capture(orderCaptor)
        )
        val capturedParam: OrderEntityKt = orderCaptor.value
        Assertions.assertEquals("order-id", capturedParam.orderId)
        Assertions.assertEquals("order-number", capturedParam.orderNumber)
        val itemCount = capturedParam.itemCount
        Assertions.assertTrue(
            itemCount in 0..100
        )
    }

    @Test
    fun test_8b() {
        // Action
        orderServiceKt.saveSomethingWithNewInstance("order-id", "order-number")

        Mockito.verify(orderRepositoryKt).saveOrderEntityKt(
            argThat {
                this.orderId == "order-id" && this.orderNumber == "order-number" && this.itemCount in 0..100
            }
        )
    }


    @Test
    fun test_9a() {
        // Action
        orderServiceKt.saveSomethingWithNewInstanceOfJava("order-id", "order-number")
        val orderCaptor: ArgumentCaptor<OrderEntityJv> = ArgumentCaptor.forClass(OrderEntityJv::class.java)

        Mockito.verify(orderRepositoryKt).saveOrderEntityJv(
            com.nhaarman.mockitokotlin2.capture(orderCaptor), any()
        )
        val capturedParam: OrderEntityJv = orderCaptor.value
        Assertions.assertEquals("order-id", capturedParam.orderId)
        Assertions.assertEquals("order-number", capturedParam.orderNumber)
        val itemCount = capturedParam.itemCount
        Assertions.assertTrue(
            itemCount in 0..100
        )
    }

    @Test
    fun test_9b() {
        // Action
        orderServiceKt.saveSomethingWithNewInstanceOfJava("order-id", "order-number")

        Mockito.verify(orderRepositoryKt).saveOrderEntityJv(
            argThat {
                this.orderId == "order-id" && this.orderNumber == "order-number" && this.itemCount in 0..100
            },
            argThat {
                this.isNotEmpty()
            }
        )
    }

    @Test
    fun test_10a() {
        val expected = OrderEntityJv("order-id", "order-number", 99)
        // Action
        orderServiceKt.saveSomethingWithNewInstanceOfJavaWhichWeCanPredict("order-id", "order-number", 99)

        Mockito.verify(orderRepositoryKt).saveOrderEntityJv(eq(expected) , any())
    }
}