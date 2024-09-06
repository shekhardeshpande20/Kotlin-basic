package com.thoughtworks.kotlin_basic.newFiles

import com.thoughtworks.kotlin_basic.newFiles.repo.ProductRepository
import com.thoughtworks.kotlin_basic.newFiles.view.ProductDisplay
import com.thoughtworks.kotlin_basic.util.PrintUtil

fun main(args: Array<String>) {
    println("Hello World!")
    println("Program arguments: ${args.joinToString()}")

    val printUtil = PrintUtil()

    // Existing functionality for printing a table
    val headers = listOf("ID", "Name", "Occupation")
    val rows = listOf(
        listOf("1", "Alice", "Software Engineer"),
        listOf("2", "Bob", "Data Scientist"),
        listOf("3", "Charlie", "Product Manager")
    )
    printUtil.printTable(headers, rows)

    // New functionality to fetch and display products
    fetchAndDisplayProducts()
}

fun fetchAndDisplayProducts() {
    val repository = ProductRepository()
    val productDisplay = ProductDisplay(repository)
    productDisplay.displayProducts()
}
