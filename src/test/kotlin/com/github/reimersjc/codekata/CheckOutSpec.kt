package com.github.reimersjc.codekata

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertEquals

/**
 * Created by jason on 2/5/17.
 */
class CheckOutSpec : Spek ({

    describe("totals") {

        fun price(skus: String): Int {
            val itemDAO = ItemDAO()
            val checkOut = CheckOut(setOf(
                    PricingRule(itemDAO.getItem("A"), 3, 130),
                    PricingRule(itemDAO.getItem("B"), 2, 45)))
            skus.split("").forEach { sku -> if (sku != "") {checkOut.scan(sku)} }
            return checkOut.total()
        }

        it("should equal 0 when no items are scanned") {
            assertEquals(0, price(""))
        }

        it("should equal 50 when A is scanned") {
            assertEquals(50, price("A"))
        }

        it("should equal 80 when AB is scanned") {
            assertEquals(80, price("AB"))
        }

        it("should equal 115 when CDBA is scanned") {
            assertEquals(115, price("CDBA"))
        }

        it("should equal 100 when AA is scanned") {
            assertEquals(100, price("AA"))
        }

        it("should equal 130 when AAA is scanned") {
            assertEquals(130, price("AAA"))
        }

        it("should equal 180 when AAAA is scanned") {
            assertEquals(180, price("AAAA"))
        }

        it("should equal 230 when AAAAA is scanned") {
            assertEquals(230, price("AAAAA"))
        }

        it("should equal 260 when AAAAAA is scanned") {
            assertEquals(260, price("AAAAAA"))
        }

        it("should equal 160 when AAAB is scanned") {
            assertEquals(160, price("AAAB"))
        }

        it("should equal 175 when AAABB is scanned") {
            assertEquals(175, price("AAABB"))
        }

        it("should equal 190 when AAABBD is scanned") {
            assertEquals(190, price("AAABBD"))
        }

        it("should equal 190 when DABABA is scanned") {
            assertEquals(190, price("DABABA"))
        }
    }
})
