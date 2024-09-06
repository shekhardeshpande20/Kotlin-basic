package com.thoughtworks.kotlin_basic.newFiles.repo


import com.thoughtworks.kotlin_basic.newFiles.api.ProductApi
import com.thoughtworks.kotlin_basic.newFiles.model.Inventory
import com.thoughtworks.kotlin_basic.newFiles.model.Product
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductRepository {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://localhost:3000/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api = retrofit.create(ProductApi::class.java)

    fun fetchProducts(callback: (List<Product>) -> Unit) {
        api.getProducts().enqueue(object : retrofit2.Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: retrofit2.Response<List<Product>>) {
                response.body()?.let { callback(it) }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                // Handle failure
            }
        })
    }

    fun fetchInventories(callback: (List<Inventory>) -> Unit) {
        api.getInventories().enqueue(object : retrofit2.Callback<List<Inventory>> {
            override fun onResponse(call: Call<List<Inventory>>, response: retrofit2.Response<List<Inventory>>) {
                response.body()?.let { callback(it) }
            }

            override fun onFailure(call: Call<List<Inventory>>, t: Throwable) {
                // Handle failure
            }
        })
    }
}
