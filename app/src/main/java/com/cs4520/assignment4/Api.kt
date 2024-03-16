package com.cs4520.assignment4

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object Api {
    const val BASE_URL: String = "https://kgtttq6tg9.execute-api.us-east-2.amazonaws.com/"
    const val ENDPOINT: String = "prod/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Api.BASE_URL)
            .build()
    }

    val productApi : ProductApiService by lazy {
        Api.retrofit.create(ProductApiService::class.java)
    }

}


interface ProductApiService {
    @GET(Api.ENDPOINT)
    suspend fun getProducts(): Response<List<Product>>
}
