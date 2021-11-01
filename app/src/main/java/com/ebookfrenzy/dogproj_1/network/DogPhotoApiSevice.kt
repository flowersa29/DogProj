package com.ebookfrenzy.dogproj_1.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://dog.ceo/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface DogPhotoApiService {
    @GET("breeds/image/random")
    suspend fun getRandomPhoto(): DogPhoto

}

object DogPhotoApi {
    val retrofitService: DogPhotoApiService by lazy {
        retrofit.create((DogPhotoApiService::class.java))
    }
}