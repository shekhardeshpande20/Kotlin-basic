package com.thoughtworks.kotlin_basic.newFiles.view


import com.thoughtworks.kotlin_basic.newFiles.model.Product
import com.thoughtworks.kotlin_basic.newFiles.model.Inventory
import com.thoughtworks.kotlin_basic.newFiles.repo.ProductRepository
import com.thoughtworks.kotlin_basic.newFiles.service.PriceService

class ProductDisplay(private val repository: ProductRepository) {
    private val priceService = PriceService()

    fun displayProducts() {
        repository.fetchProducts { products ->
            repository.fetchInventories { inventories ->
                val inventoryMap = inventories.groupBy { it.sku }
                    .mapValues { entry -> entry.value.sumOf { it.stock } }

                products.forEach { product ->
                    val totalStock = inventoryMap[product.sku] ?: 0
                    val price = priceService.calculatePrice(product, totalStock)
                    println("SKU: ${product.sku}, Name: ${product.name}, Price: $price, Stock: $totalStock, Image: ${product.imageUrl}")
                }
            }
        }
    }
}
