package com.cs4520.assignment4

import android.annotation.SuppressLint
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

class ProductListDatabaseProvider {
    var db: ProductDatabase? = null

    @SuppressLint("StaticFieldLeak")
    var context: Context? = null

    fun getDatabase(): ProductDatabase {
        if (db == null) {
            db = context?.let {
                Room.databaseBuilder(
                    it,
                    ProductDatabase::class.java,
                    "ProductListDatabase"
                ).build()
            }
        }
        return db!!
    }

}