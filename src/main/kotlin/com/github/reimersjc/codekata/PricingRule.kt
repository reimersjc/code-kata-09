package com.github.reimersjc.codekata

/**
 * Created by jason on 2/7/17.
 */
interface PricingRule {

    /**
     * Calculates the discount for items that are in the cart. If no applicable
     * items are discountable, method returns 0.
     */
    fun calculateDiscount(cart: Map<Item, Int>, currentDiscount: Int): Int

}