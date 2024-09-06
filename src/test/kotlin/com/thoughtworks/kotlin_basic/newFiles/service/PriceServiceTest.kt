package com.thoughtworks.kotlin_basic.newFiles.service


import com.thoughtworks.kotlin_basic.newFiles.model.Product
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PriceServiceTest {
    private val priceService = PriceService()

    @Test
    fun `test price for NORMAL product`() {
        val product = Product("sku1", "Product A", 100.0, "NORMAL", "http://image.url")
        val price = priceService.calculatePrice(product, 50)
        assertEquals(100.0, price)
    }

    @Test
    fun `test price for HIGH_DEMAND product with stock greaterThan 100`() {
        val product = Product("sku2", "Product B", 100.0, "HIGH_DEMAND", "http://image.url")
        val price = priceService.calculatePrice(product, 150)
        assertEquals(100.0, price)
    }

    @Test
    fun `test price for HIGH_DEMAND product with stock lessThanEqualTo 100 and greaterThan 30`() {
        val product = Product("sku3", "Product C", 100.0, "HIGH_DEMAND", "http://image.url")
        val price = priceService.calculatePrice(product, 50)
        assertEquals(120.0, price)
    }

    @Test
    fun `test price for HIGH_DEMAND product with stock lessThanEqualTo 30`() {
        val product = Product("sku4", "Product D", 100.0, "HIGH_DEMAND", "http://image.url")
        val price = priceService.calculatePrice(product, 20)
        assertEquals(150.0, price)
    }
}
