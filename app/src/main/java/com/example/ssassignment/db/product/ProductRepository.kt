package com.example.ssassignment.db.product

import androidx.lifecycle.LiveData

class ProductRepository(private val productDAO: ProductDAO) {

    val allProductDetails: LiveData<List<Product>> = productDAO.getAllProducts()

    suspend fun addProduct(product: Product){
        productDAO.insertProduct(product)
    }
}