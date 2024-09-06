package com.thoughtworks.kotlin_basic.newFiles.service

import com.thoughtworks.kotlin_basic.newFiles.model.Product

class PriceService {
    fun calculatePrice(product: Product, totalStock: Int): Double {
        val originalPrice = product.price
        return when {
            product.type == "NORMAL" -> originalPrice
            totalStock > 100 -> originalPrice
            totalStock in 31..100 -> originalPrice * 1.20
            else -> originalPrice * 1.50
        }
    }
}
