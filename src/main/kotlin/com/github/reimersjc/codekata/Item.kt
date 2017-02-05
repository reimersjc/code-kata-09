package com.github.reimersjc.codekata

/**
 * Created by jason on 2/5/17.
 */
class Item(val sku: String, val unitPrice: Int) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as Item

        if (sku != other.sku) return false

        return true
    }

    override fun hashCode(): Int {
        return sku.hashCode()
    }

    override fun toString(): String {
        return "Item(sku='$sku', unitPrice=$unitPrice)"
    }


}