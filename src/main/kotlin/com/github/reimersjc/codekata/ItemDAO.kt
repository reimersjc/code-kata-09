package com.github.reimersjc.codekata

/**
 * Created by jason on 2/5/17.
 */
class ItemDAO {

    val mockItems = mapOf<String, Item>(
            "A" to Item("A", 50),
            "B" to Item("B", 30),
            "C" to Item("C", 20),
            "D" to Item("D", 15))

    fun getItem(sku: String): Item {
        return mockItems.getOrElse(sku) {
            throw IllegalArgumentException("item not in inventory!")
        }
    }
}