package com.cs4520.assignment4

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Product::class], version = 1)
abstract class ProductDatabase: RoomDatabase() {
    abstract fun getProductListDao(): ProductListDao;
}