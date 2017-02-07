package com.github.reimersjc.codekata

/**
 * Created by jason on 2/5/17.
 */
class ItemDAO {

    val mockItems = listOf<Item>(
            Item("A", 50),
            Item("B", 30),
            Item("C", 20),
            Item("D", 15)
    )

    fun getItem(sku: String): Item {
        return mockItems.find { item -> item.sku == sku } ?: throw IllegalArgumentException("item not in inventory!")
    }

}