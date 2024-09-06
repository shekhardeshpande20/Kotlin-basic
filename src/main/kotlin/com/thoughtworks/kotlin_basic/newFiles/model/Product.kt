package com.thoughtworks.kotlin_basic.newFiles.model


data class Product(
    val sku: String,
    val name: String,
    val price: Double,
    val type: String,
    val imageUrl: String
)

data class Inventory(
    val sku: String,
    val stock: Int
)
