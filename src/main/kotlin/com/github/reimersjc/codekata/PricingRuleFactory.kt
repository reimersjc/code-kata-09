package com.github.reimersjc.codekata

/**
 * Created by jason on 2/6/17.
 */
class PricingRuleFactory private constructor() {

    companion object Factory {
        val itemDAO = ItemDAO()

        fun getChain(): PricingRule {
            val discountA = QtyDiscountPricingRule(itemDAO.getItem("A"), 3, 130)
            val discountB = QtyDiscountPricingRule(itemDAO.getItem("B"), 2, 45)
            discountA.successor = discountB
            return discountA
        }

    }

}