package com.example.ssassignment.db.category

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category_details")
data class Category(
    var categoryName: String,
    //var categoryImage: Bitmap? = null

) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
