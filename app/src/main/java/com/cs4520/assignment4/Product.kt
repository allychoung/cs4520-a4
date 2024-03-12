package com.cs4520.assignment4

sealed class Product(
    open val name: String,
    open val expirationDate: String?,
    open val price: Int) {
    abstract fun getBackgroundImg(): Int
}

data class Equipment(
    override val name: String,
    override val expirationDate: String?,
    override val price: Int
) : Product(name, expirationDate, price) {
    override fun getBackgroundImg(): Int {
        return R.drawable.equipment
    }
}

data class Food(
    override val name: String,
    override val expirationDate: String?,
    override val price: Int
) : Product(name, expirationDate, price) {
    override fun getBackgroundImg(): Int {
        return R.drawable.food
    }
}
