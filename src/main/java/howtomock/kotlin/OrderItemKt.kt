package howtomock.kotlin

class OrderItemKt(private val itemNames: List<String>) {

    fun getOrderVolume() : String {
        return someCalculation(itemNames)
    }

    private fun someCalculation(itemNames: List<String>): String {
        return when (itemNames.size) {
            in 0..10 -> {
                "Small order"
            }

            in 10..20 -> {
                "Medium order"
            }

            else -> {
                "Large order"
            }
        }
    }
}