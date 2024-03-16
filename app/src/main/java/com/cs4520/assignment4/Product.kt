package com.cs4520.assignment4

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class Product (
    @PrimaryKey val name: String,
    val type: String,
    val expDate: String?,
    val price: String
)

