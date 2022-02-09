package com.example.ssassignment.db.product

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.ssassignment.db.category.Category
import java.util.*

@Dao
interface ProductDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product: Product)

    @Delete
    suspend fun deleteProduct(product: Product)

    @Query("select * from product_details order by id asc")
    fun getAllProducts(): LiveData<List<Product>>

    @Query("select *  from product_details where categoryName =:category order by id asc")
    fun getProductForCategory(category: String): LiveData<List<Product>>

}