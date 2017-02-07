package com.github.reimersjc.codekata

/**
 * Created by jason on 2/5/17.
 */
class CheckOut {

    private val cart = hashMapOf<Item, Int>()
    private val itemDAO = ItemDAO()

    fun scan(sku: String) {
        val item = itemDAO.getItem(sku)

        // Update qty of item in cart, adding if it does not exist
        cart.compute(item) { item, qty -> (qty ?: 0).inc() }
    }

    fun total(): Int {
        // Calculate total without discounts
        val total = cart
                .map { it.key.unitPrice * it.value }
                .fold(0) { total, next -> total + next }

        // Calculate and apply discounts for each pricing rule in chain
        val discount = PricingRuleFactory.getChain().calculateDiscount(cart, 0)

        return total - discount
    }
}