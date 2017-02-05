package com.github.reimersjc.codekata

/**
 * Created by jason on 2/5/17.
 */
class CheckOut(val pricingRules: Set<PricingRule>) {

    private val cart = hashMapOf<Item, Int>()
    private val itemDAO = ItemDAO()

    fun scan(sku: String) {
        val item = itemDAO.getItem(sku)
        var quantity = cart.getOrPut(item) { 0 }
        cart[item] = ++quantity
    }

    fun total(): Int {
        var total = 0

        // Calculate total without discounts
        cart.forEach { item, quantity ->  total += (item.unitPrice * quantity) }

        // Calculate and apply discounts for each pricing rule
        // Each pricing rule is evaluated, which may result in a $0 discount if no discountable
        // or not enough discountable items are in the cart
        pricingRules.forEach { pricingRule -> total -= pricingRule.calculateDiscount(cart) }

        return total
    }
}