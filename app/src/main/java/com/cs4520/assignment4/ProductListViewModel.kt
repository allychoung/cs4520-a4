package com.cs4520.assignment4

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ProductListViewModel(application: Application) : AndroidViewModel(application) {
    private val repo: ProductRepo = ProductRepo()

    private val items = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> = items
    val loading = MutableLiveData<Boolean>(true)

    val noProducts = MutableLiveData<Boolean>(false)

    fun loadData() {

        viewModelScope.launch {
            try {
                val data = listOf<Product>()
//                val data = repo.fetchAll()
                if (data.size == 0) {
                    noProducts.value = true
                    loading.value = false
                } else {
                    loading.value = false
                    items.value = data
                }
            } catch (e: Error) {

            }
        }
    }
}