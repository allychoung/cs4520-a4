package com.cs4520.assignment4

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ProductListViewModel(application: Application) : AndroidViewModel(application) {
    private val repo: ProductRepo = ProductRepo(application.applicationContext)

    private val items = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> = items

    val isLoading = MutableLiveData<Boolean>(true)

    val noProducts = MutableLiveData<Boolean>(false)

    fun loadData() {

        viewModelScope.launch {
            try {
                val data = repo.fetchAll()
                if (data.length == 0) {
                    noProducts.postValue(true)
                    isLoading.postValue(false)
                } else {
                    isLoading.postValue(false)
                    items.postValue(data)
                }
            } catch (e: Error) {
                isLoading.postValue(false)
                noProducts.postValue(false)
            }
        }
    }
}