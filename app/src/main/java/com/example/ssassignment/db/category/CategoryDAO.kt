package com.example.ssassignment.db.category

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.ssassignment.db.product.Product

@Dao
interface CategoryDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(category: Category)

    @Delete
    suspend fun deleteCategory(category: Category)

    @Query("select * from category_details order by categoryName asc")
    fun getAllCategory(): LiveData<List<Category>>
}