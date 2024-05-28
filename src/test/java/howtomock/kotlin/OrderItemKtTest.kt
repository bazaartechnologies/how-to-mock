package howtomock.kotlin

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class OrderItemKtTest {
    val items : List<String> = emptyList()
    private lateinit var orderItemKt: OrderItemKt

    @BeforeEach
    fun before() {
        orderItemKt = OrderItemKt(items)
    }
}