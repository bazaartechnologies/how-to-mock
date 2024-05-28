package howtomock.kotlin

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.mockito.Spy
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.whenever
import kotlin.random.Random

@ExtendWith(MockitoExtension::class)
internal class OrderItemKtTest {

    @Spy
    val items : List<String> = emptyList()
    private lateinit var orderItemKt: OrderItemKt

    @BeforeEach
    fun before() {
        orderItemKt = OrderItemKt(items)
    }

    @ParameterizedTest
    @ValueSource(ints = [1,2,3,4,5,6,7,8,9,10])
    fun checkForSmallVolume(size: Int) {
        whenever(items.size).thenReturn(size)
        val orderVolume = orderItemKt.getOrderVolume()
        assertEquals("Small order", orderVolume)
    }

    @ParameterizedTest
    @ValueSource(ints = [11,12,13,14,15,16,17,18,19,20])
    fun checkForMediumVolume(size: Int) {
        whenever(items.size).thenReturn(size)
        val orderVolume = orderItemKt.getOrderVolume()
        assertEquals("Medium order", orderVolume)
    }


    @Test
    fun checkForLargeVolume() {
        whenever(items.size).thenReturn(Random.nextInt(21, Int.MAX_VALUE))
        val orderVolume = orderItemKt.getOrderVolume()
        assertEquals("Large order", orderVolume)
    }
}