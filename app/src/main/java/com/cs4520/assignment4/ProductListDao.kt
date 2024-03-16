package com.cs4520.assignment4

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg items: Product)

    @Query("SELECT * FROM items")
    fun getProducts()
}