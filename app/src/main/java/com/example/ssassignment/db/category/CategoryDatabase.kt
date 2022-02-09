package com.example.ssassignment.db.category

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ssassignment.db.product.ProductDatabase

@Database(
    entities = [Category::class],
    version = 1
)
public abstract class CategoryDatabase: RoomDatabase() {

    abstract fun getCategoryDAO(): CategoryDAO

    companion object{
        @Volatile
        private var INSTANCE: CategoryDatabase? = null

        fun getDatabase(context: Context): CategoryDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return  tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CategoryDatabase::class.java,
                    "category_details"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}