package com.example.ssassignment.db.product

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_details")
data class Product(
    var productName: String,
    var categoryName: String,
    //var productImage: Bitmap? = null,
    var quantity: Int,
    var price: Int
){
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
