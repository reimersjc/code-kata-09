package com.github.reimersjc.codekata

/**
 * A pricing rule will calculate a discount for an item. E.g. for item A, the price
 * is 130 for quantity of 3. For each 3 of the discountable item, the discount will
 * be applied. The pricing rule does not change the unit price. In other words, 3 for 130
 * would still charge full price of the 4th item in the cart (when the user has 4 of the item).
 *
 * @property item the item the pricing rule applies to
 * @property quantity the number of items the price applies to
 * @property price the total price for the quantity
 */
class PricingRule(val item: Item, val quantity: Int, val price: Int) {

    var successor: PricingRule? = null

    fun calculateDiscount(cart: Map<Item, Int>, currentDiscount: Int): Int {
        val itemQty = cart.getOrElse(item) { 0 }

        if (isDiscountable(itemQty)) {
            // Quantity to apply (e.g. if 2 for 130 and item qty is 7, discountable qty is 3
            val discountableQty = itemQty / quantity

            // Original price of discountable item, not including extra quantities that cannot be discounted
            val originalPriceOfDiscountableItems = (discountableQty * quantity) * item.unitPrice

            // Discount applied at checkout, added to current discount
            return (currentDiscount + (originalPriceOfDiscountableItems - (discountableQty * price)))
                    .let { successor?.calculateDiscount(cart, it) ?: it }
        } else {
            return currentDiscount.let { successor?.calculateDiscount(cart, it) ?: it }
        }
    }

    fun isDiscountable(itemQty: Int): Boolean {
        return itemQty >= quantity
    }

}