package howtomock.kotlin

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class OrderServiceKtTest {
    private lateinit var orderRepositoryKt: OrderRepositoryKt
    private lateinit var orderServiceKt: OrderServiceKt

    @BeforeEach
    fun setup() {
        orderServiceKt = OrderServiceKt(orderRepositoryKt)
    }

}